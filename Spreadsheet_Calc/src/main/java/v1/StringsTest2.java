package v1;

/**
 * Created by vkroz on 7/10/14.
 */
public class StringsTest2 {
    String[] row;

    void modify() {
        for(int i=0; i< row.length; i++) {
            row[i] = "xxx";
        }
    }
}
