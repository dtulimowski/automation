package io.other;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Watchmaker {
    public static String getCurrentTime(String format) {
        // formatter = formatter("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = new Date();
        return formatter.format(date);
    }

}
