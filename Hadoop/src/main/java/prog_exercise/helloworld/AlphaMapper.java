package prog_exercise.helloworld;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Michael Holt
 * Date: 9/20/13
 * Time: 12:51 AM
 */
public class AlphaMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    /**
     * Takes in a word and count of occurences. Outputs the 1st character of the word and the count.
     * @param key - The byte offset. Not used.
     * @param value - A word and an occurrence count, whitespace delimited.
     * @param context - The job Context object.
     * @throws java.io.IOException
     * @throws InterruptedException
     */
    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String values[] = line.split("\\W+");
        if (values.length == 2) {
            context.write(new Text(values[0].substring(0,1).toLowerCase()), new IntWritable(Integer.parseInt(values[1])));
        }

    }
}
