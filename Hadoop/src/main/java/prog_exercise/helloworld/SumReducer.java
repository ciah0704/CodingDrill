package prog_exercise.helloworld;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SumReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
    /**
     * A very simple reducer that iterates through numerical values and sums them.
     * @param key - A string we found in text
     * @param values - An Iterable of IntWritables counting occurrences
     * @param context - The job Context object
     * @throws java.io.IOException
     * @throws InterruptedException
     */
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int wordCount = 0;
        for (IntWritable value : values) {
            wordCount += value.get();
        }
        context.write(key, new IntWritable(wordCount));
    }
}