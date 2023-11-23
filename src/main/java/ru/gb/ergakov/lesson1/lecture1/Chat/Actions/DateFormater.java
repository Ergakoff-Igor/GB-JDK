package ru.gb.ergakov.lesson1.lecture1.Chat.Actions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormater {

    final static DateTimeFormatter customFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String LocalDateTimeToString(LocalDateTime date) {
        return date.format(customFormater);
    }

    public LocalDateTime StringToLocalDateTime(String text) {
        return LocalDateTime.parse(text, customFormater);
    }
}
