$HADOOP_HOME/bin/hadoop jar /opt/hadoop-3.2.1/share/hadoop/tools/lib/hadoop-streaming-3.2.1.jar -file /opt/hadoop/applications/streampython/mappermountunix.py -mapper mappermountunix.py -file /opt/hadoop/applications/streampython/reducermountunix.py -reducer reducermountunix.py -input $INPUT -output $OUTPUT
touch /tmp/ss.txt
tail -f /tmp/ss.txt
