package com.ib.formatter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.format.Formatter;



public class DateFormatter  implements Formatter<Date>{
    final String defaultDateFormat = "dd/MM/yyyy";

    @Override
    public String print(Date object, Locale locale) {
        return new SimpleDateFormat(defaultDateFormat).format(object);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDateFormat);
        return new Date(sdf.parse(text).getTime());
    }

}
