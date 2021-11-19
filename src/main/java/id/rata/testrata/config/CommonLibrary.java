package id.rata.testrata.config;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class CommonLibrary {

    public Date getDateTimeNow() {
        Calendar calendar = Calendar.getInstance();
        return new Timestamp(calendar.getTimeInMillis());
    }

}
