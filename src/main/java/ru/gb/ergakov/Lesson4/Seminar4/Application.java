package ru.gb.ergakov.Lesson4.Seminar4;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpServer;

class Application {

    public static void main(String[] args) throws IOException {
        int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0); // Тут просто создаем объект класса

        server.createContext("/api/hello", (exchange -> { // Тут описываем т.н. endpoint, то есть куда стучимся при
            // подключении и как на это реагировать

            if ("GET".equals(exchange.getRequestMethod())) {// Прописываем действия для метода GET
                Map<String, List<String>> params = splitQuery(exchange.getRequestURI().getRawQuery());
                String noNameText = "Anonymous";
                String name = params.getOrDefault("name", List.of(noNameText)).stream().findFirst().orElse(noNameText);
                String respText = String.format("Hello, %s!", name);
                exchange.sendResponseHeaders(200, respText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(respText.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Остальные методы должны выпадать в ошибку
            }
            exchange.close();
        }));
        server.setExecutor(null); // Тут создаем поток выполнения, сервер будет крутиться, пока не надоест

        server.start(); // Запускаем поток с сервером
    }

    // Этот метод для того, чтобы разделить строку на параметры по значку & параметр
    // и его название делятся с помощью =
    public static Map<String, List<String>> splitQuery(String query) {
        if (query == null || "".equals(query)) {
            return Collections.emptyMap();
        }

        return Pattern.compile("&").splitAsStream(query)
                .map(s -> Arrays.copyOf(s.split("="), 2))
                .collect(groupingBy(s -> decode(s[0]), mapping(s -> decode(s[1]), toList())));

    }

    private static String decode(final String encoded) {
        try {
            return encoded == null ? null : URLDecoder.decode(encoded, "UTF-8");
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 is a required encoding", e);
        }
    }
}
