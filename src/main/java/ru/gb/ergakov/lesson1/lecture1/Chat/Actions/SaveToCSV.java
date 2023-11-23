package ru.gb.ergakov.lesson1.lecture1.Chat.Actions;

import ru.gb.ergakov.lesson1.lecture1.Chat.Models.Message;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToCSV {

    DateFormater dateFormater = new DateFormater();

    public void save(String path, Message message) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.append(String.format("%s, ", dateFormater.LocalDateTimeToString(message.getDate())));
            writer.append(String.format("%s, ", message.getLogin()));
            writer.append(String.format("%s\n", message.getText()));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
