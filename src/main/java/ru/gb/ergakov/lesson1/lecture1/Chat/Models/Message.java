package ru.gb.ergakov.lesson1.lecture1.Chat.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private LocalDateTime date;
    private String login;
    private String text;

    @Override
    public String toString() {
        return String.format("%s, %s, %s", date, login, text);
    }
}
