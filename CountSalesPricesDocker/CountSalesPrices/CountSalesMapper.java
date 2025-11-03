package CountSales;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class CountSalesMapper extends Mapper<Object, Text, Text, IntWritable> {
    
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String val = value.toString();
        String[] row = val.split(",");
        Text country = new Text(row[7]);
        IntWritable price = new IntWritable(0);
        try {
            price = new IntWritable(Integer.parseInt(row[2]));
        } catch (NumberFormatException e) {
            price = new IntWritable(0);
        }
        context.write(country, price);
    }
}