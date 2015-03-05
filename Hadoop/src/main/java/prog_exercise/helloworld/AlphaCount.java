package prog_exercise.helloworld;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.jobcontrol.ControlledJob;
import org.apache.hadoop.mapreduce.lib.jobcontrol.JobControl;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Michael Holt
 * Date: 9/20/13
 * Time: 12:44 AM
 */
public class AlphaCount extends Configured implements Tool {

    private final Logger log = LoggerFactory.getLogger(AlphaCount.class);

    public int run(String[] args) throws Exception {
        // Make sure we got our input and output paths
        if (args.length != 2) {
            System.out.printf(
                    "Usage: %s [generic options] <input dir> <output dir>\n", getClass().getSimpleName());
            return -1;
        }
        Configuration configuration = getConf();
        String tempDirectory = getClass().getSimpleName() + "-tmp/";
        Integer success = 0;

        // Setup the word count job
        Job job1 = new Job(configuration, "Word Count");
        job1.setJarByClass(AlphaCount.class);
        FileInputFormat.setInputPaths(job1, new Path(args[0]));
        FileOutputFormat.setOutputPath(job1, new Path(tempDirectory));
        job1.setMapperClass(WordMapper.class);
        job1.setReducerClass(SumReducer.class);
        // Note the combiner!
        job1.setCombinerClass(SumReducer.class);
        job1.setMapOutputKeyClass(Text.class);
        job1.setMapOutputValueClass(IntWritable.class);
        job1.setOutputKeyClass(Text.class);
        job1.setOutputValueClass(IntWritable.class);

        // Setup the first letter count
        Job job2 = new Job(getConf(), "Alpha Count");
        job2.setJarByClass(AlphaCount.class);
        FileInputFormat.setInputPaths(job2, new Path(tempDirectory));
        FileOutputFormat.setOutputPath(job2, new Path(args[1]));
        job2.setMapperClass(AlphaMapper.class);
        job2.setReducerClass(SumReducer.class);
        // We could use the combiner again
        job2.setMapOutputKeyClass(Text.class);
        job2.setMapOutputValueClass(IntWritable.class);
        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(IntWritable.class);

        // Now configure the JobControl and dependencies
        JobControl jobControl = new JobControl("Alpha Count Group");
        ControlledJob step1 = new ControlledJob(configuration);
        step1.setJob(job1);
        ControlledJob step2 = new ControlledJob(configuration);
        step2.setJob(job2);
        step2.addDependingJob(step1);

        jobControl.addJob(step1);
        jobControl.addJob(step2);

        /*
        JobControl needs to spawn in its own thread.
        Unfortunately this suppresses log out.
         */
        Thread workflowThread = new Thread(jobControl, "Workflow-Thread");
        workflowThread.setDaemon(true);
        workflowThread.start();

        // Wait until it's finished then validate
        while (!jobControl.allFinished()) {
            Thread.sleep(500);
        }

        if (jobControl.getFailedJobList().size() > 0) {
            // Uh oh we have failed jobs!
            log.error(jobControl.getFailedJobList().size() + " jobs failed!");

            for (ControlledJob job : jobControl.getFailedJobList()) {
                log.error(job.getJobName() + " failed.");

                success = 0;
            }
        } else {
            log.info("Success! Workflow Completed [" + jobControl.getSuccessfulJobList().size() + "] jobs!");

            success = 1;
        }

        return success;
    }
    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new Configuration(), new AlphaCount(), args);
        System.exit(exitCode);
    }
}
