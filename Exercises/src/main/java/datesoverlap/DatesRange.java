package datesoverlap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatesRange {
    Date dateFrom;
    Date dateTo;

    public DatesRange(String fromStr, String toStr) throws ParseException {
        this.dateFrom = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(fromStr);
        this.dateTo = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(toStr);
    }

    /**
     * Returns new dates range representing overlapping days of 2 ranges
     * @param range
     * @return DatesRange containing overallping days
     */
    public DatesRange overlappingRange(DatesRange range) {

        return null;
    }
}
