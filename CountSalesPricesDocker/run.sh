$HADOOP_HOME/bin/hadoop jar /home/CountSalesPrices/CountSalesPrice.jar /user/root/salesdata/ $OUTPUT
mkdir -p /tmp/salesdataoutput/
hdfs dfs -get $OUTPUT /tmp/salesdataoutput/
python /home/DataReader/datareader.py
touch /tmp/s.txt
tail -f /tmp/s.txt