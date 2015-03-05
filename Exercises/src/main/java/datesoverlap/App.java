package datesoverlap;

import java.text.ParseException;

/**
 * Created by vkroz on 7/3/14.
 */
public class App {
    static public void main(String[] args) {

        try {
            DatesRange dr1 = new DatesRange("2014-03-26", "2014-07-14");
            DatesRange dr2 = new DatesRange("2014-07-14", "2014-09-04");

            DatesRange overlap = dr1.overlappingRange(dr2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
