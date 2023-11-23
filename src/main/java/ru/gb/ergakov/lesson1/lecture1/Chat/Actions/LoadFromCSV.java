package ru.gb.ergakov.lesson1.lecture1.Chat.Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ru.gb.ergakov.lesson1.lecture1.Chat.Models.Message;
import javax.swing.*;

public class LoadFromCSV extends JFrame {
    DateFormater dateFormater = new DateFormater();
    private Message message;
    StringBuilder stringBuilder = new StringBuilder();

    public String load(String path) {
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                message = getRecordFromLine(scanner.nextLine());
                stringBuilder.append(String.format("%s: %s\n", message.getLogin(), message.getText()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public Message getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(", ");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
            message = new Message(
                    dateFormater.StringToLocalDateTime(values.get(0)), values.get(1), values.get(2));
        }
        return message;
    }
}
