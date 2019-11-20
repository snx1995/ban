package art.banyq.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String format(Date date, String format) {
        SimpleDateFormat sdm = new SimpleDateFormat(format);
        return sdm.format(date);
    }
}
