prog_exercise.combiners.CombineDemo - A combiner example 
===
Demonstrates use of combiners to pre-process data after map phase, before sending over to reducers


prog_exercise.helloworld.AlphaCount - A MapReduce Example
===

The goal of this project is to provide a simple to understand yet complex MapReduce workflow example. Notable features in this project include:

1. Chaining of jobs using JobController
1. Unit test using MRUnit
1. Implementation of a combiner

Using the project
-----------------
This is a complete Maven project and will load into IntelliJ or any other Maven IDE. One loaded into the IDE you can insert stop points and run the test just as you would a regular JUnit test.

To execute the job, first upload the included MacBeth.txt file to HDFS:


    hadoop fs -mkdir input
    hadoop fs -put MacBeth.txt input/

Package the jar either from your IDE or the command line:

    mvn clean package

If you need to upload the jar to another server so that you can submit the job, you should do so now.

Submit the job:

    hadoop jar MapReduceExample-1.0-SNAPSHOT.jar prog_exercise.helloworld.AlphaCount input/Macbeth.txt output/ac

Note that as part of the execution the job will create a directory named `prog_exercise.helloworld.AlphaCount-tmp`. This is where intermediate data is stored so you can see the results of the first step of the job.

What's with the combiner?
---

A combiner runs on data from a single mapper before that data is sent across the network. NOTE: it is NOT garaunteed the combiner will run! The combiner needs to emit the same key/value types as it consumes, so that it fits perfectly between the mapper and reducer. Because in this example we are doing a simple sum, we can use our mapper class as our combiner, gaining us some possible efficiency with only a single line of code.

Using Oozie
---

The sample oozie workflow will do the following:

1. Use sqoop to export a table from a database
1. Use the Wordcount and prog_exercise.helloworld.SumReducer classes from MapReduceExample-1.0-SNAPSHOT.jar on the database output
1. Use sqoop to import the MR results into a(nother) database

Assuming you have Oozie and Sqoop installed and you have built the example jar, you need to perform the following steps to execute the Oozie workflow:

    hadoop fs -mkdir oozieTesting
    hadoop fs -mkdir oozieTesting/lib
    hadoop fs -put src/main/resources/oozie/workflow.xml oozieTesting/
    hadoop fs -put target/MapReduceExample-1.0-SNAPSHOT.jar oozieTesting/lib/

You now need to create the table for exporting data. Connect to the target database and run the following command:

    create table counts(word varchar not null,count int not null);

Finally you need to edit job.properties file. The comments in this file should explain each entry sufficiently. When you have finished you can execute your workflow with the following command:

   oozie job -config ./job.properties -run

You can monitor the job progress through the Oozie web console: http://<oozie host>:11000/oozie/ 

When the job is completed, connect to your target database and query the counts table. It should now contain words which appeared in the data extract and their frequency.
