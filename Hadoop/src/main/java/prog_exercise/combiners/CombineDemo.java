package prog_exercise.combiners;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * General steps to create M/R Hadoop job
 * ===
 * # Create main driver class which extends Configured and implements Tool
 * # Implement method run() which will initialize new job(s) and execute it
 */
public class CombineDemo extends Configured implements Tool {

    Logger log = LoggerFactory.getLogger(this.getClass());

    String inPathStr;

    @Override
    public int run(String[] args) throws Exception {

        Configuration configuration = getConf();
        Job job = new Job(configuration, "Combiners Demo");
        job.setJarByClass(CombineDemo.class);
        FileInputFormat.setInputPaths(job, new Path(inPathStr));

        return 0;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new Configuration(), new CombineDemo(), args);
        System.exit(exitCode);
    }


}
