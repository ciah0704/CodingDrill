package prog_exercise.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Set of file handling utilities working transparently in standalone and distributed mode
 */
public class HdfsUtils {

    /**
     * Returns list of files located under specified path. List excludes directories
     * @param configuration
     * @param path
     * @throws java.io.IOException
     */
    public static Path[] listFiles(Configuration configuration, String path) throws IOException {
        List<Path> retval = new ArrayList<Path>();

        String fsDefaultName = configuration.get("fs.default.name");

        if (null != fsDefaultName && fsDefaultName.startsWith("hdfs"))
            /* running in distributed mode */ {
            FileSystem fs = FileSystem.get(configuration);
            Path p = new Path(path);
            for (FileStatus file : fs.listStatus(p)) {
                if (file.isFile()) {
                    retval.add(file.getPath());
                }
            }

        } else
            /* running in standalone mode */ {
            File[] ff = new File(path).listFiles();
            for (File f : ff) {
                retval.add(new Path(f.getAbsolutePath()));
            }
        }
        return retval.toArray(new Path[retval.size()]);
    }

    /**
     * Returns list of directories located under specified path.
     * @param configuration
     * @param path
     * @throws java.io.IOException
     */
    public static Path[] listDirs(Configuration configuration, String path) throws IOException {
        List<Path> retval = new ArrayList<Path>();

        String fsDefaultName = configuration.get("fs.default.name");

        if (null != fsDefaultName && fsDefaultName.startsWith("hdfs"))
            /* running in distributed mode */ {
            FileSystem fs = FileSystem.get(configuration);
            Path p = new Path(path);
            for (FileStatus file : fs.listStatus(p)) {
                if (file.isDirectory()) {
                    retval.add(file.getPath());
                }
            }

        } else
            /* running in standalone mode */ {
            for (File f : FileUtil.listFiles(new File(path))) {
                if(f.isDirectory())
                    retval.add(new Path(f.getAbsolutePath()));
            }
        }
        return retval.toArray(new Path[retval.size()]);
    }
}
