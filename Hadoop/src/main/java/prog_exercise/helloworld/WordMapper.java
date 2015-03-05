package prog_exercise.helloworld;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
    /**
     * Splits a line of text into distinct words, outputting the word and a count of 1.
     * @param key - The byte offset. Not used.
     * @param value - A line of text.
     * @param context - The job Context object.
     * @throws java.io.IOException
     * @throws InterruptedException
     */
    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        for (String word : line.split("\\W+")) {
            if (word.length() > 0) {
                context.write(new Text(word), new IntWritable(1));
            }
        }
    }
}