FROM bde2020/hadoop-base:2.0.0-hadoop3.2.1-java8


RUN sed -i 's|deb.debian.org/debian|archive.debian.org/debian|g'      /etc/apt/sources.list && \
    sed -i 's|security.debian.org/debian-security|archive.debian.org/debian-security|g' /etc/apt/sources.list && \
    sed -i '/stretch-updates/d'                                      /etc/apt/sources.list && \
    echo 'Acquire::Check-Valid-Until "false";\nAcquire::Check-Date "false";' > /etc/apt/apt.conf.d/99ignore-expired

RUN apt-get update && \
    apt-get install -y --no-install-recommends wget && \
    rm -rf /var/lib/apt/lists/*


WORKDIR /tmp
RUN wget -q https://repo.anaconda.com/miniconda/Miniconda3-py38_4.12.0-Linux-x86_64.sh && \
    bash Miniconda3-py38_4.12.0-Linux-x86_64.sh -b -p /root/miniconda3 && \
    rm Miniconda3-py38_4.12.0-Linux-x86_64.sh
RUN mkdir -p /root/.conda
ENV PATH="/root/miniconda3/bin:${PATH}"

RUN mkdir -p /home

COPY CountSalesPrices /home/CountSalesPrices
COPY DataReader /home/DataReader
ADD run.sh /tmp/run.sh
RUN chmod +x /tmp/run.sh
ADD SalesJan2009.csv /tmp/SalesJan2009.csv

ENV CLASSPATH="$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-3.2.1.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-common-3.2.1.jar:$HADOOP_HOME/share/hadoop/common/hadoop-common-3.2.1.jar:/tmp/CountSales/*:$HADOOP_HOME/lib/*:$HADOOP_HOME/share/hadoop/common/lib/commons-cli-1.2.jar"
WORKDIR /home/CountSalesPrices

RUN javac -d . CountSalesDriver.java CountSalesMapper.java CountSalesReducer.java

RUN jar cfm CountSalesPrice.jar Manifest.txt CountSales/*.class

RUN hdfs dfs -mkdir -p /user/root/salesdata

RUN hdfs dfs -mkdir -p /user/root/salesdata/countsalesprice008

RUN hdfs dfs -put /tmp/SalesJan2009.csv /user/root/salesdata/

CMD ["/tmp/run.sh"]


