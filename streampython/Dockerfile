FROM bde2020/hadoop-base:2.0.0-hadoop3.2.1-java8
RUN apt update
RUN apt install -y python
COPY . /opt/hadoop/applications/streampython/
RUN awk '{ sub("\r$", ""); print }' /opt/hadoop/applications/streampython/mappermount.py > /opt/hadoop/applications/streampython/mappermountunix.py
RUN awk '{ sub("\r$", ""); print }' /opt/hadoop/applications/streampython/reducermount.py > /opt/hadoop/applications/streampython/reducermountunix.py
RUN chmod +x /opt/hadoop/applications/streampython/mappermountunix.py
RUN chmod +x /opt/hadoop/applications/streampython/reducermountunix.py
ENV INPUT="/user/root/inputbankfull/*"
ENV OUTPUT="/user/root/outputbankfull20"

ADD run.sh /run.sh
RUN chmod a+x /run.sh

CMD ["/run.sh"]
