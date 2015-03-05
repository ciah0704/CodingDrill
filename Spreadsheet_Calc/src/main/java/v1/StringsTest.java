package v1;

/**
 * Created by vkroz on 7/10/14.
 */
public class StringsTest {

    public static void main(String[] args) {
        StringsTest app = new StringsTest();
        app.runMe(args);
    }

    private void runMe(String[] args) {
        String[][] table = {
                {"qq", "ww", "ee"},
                {"aa", "ss", "dd"}
        };

        StringsTest2 st = new StringsTest2();
        st.row = table[0];
        st.modify();
        System.out.println(table);
    }
}
