package ru.gb.ergakov.lesson1.lecture1.ServerRun;
/*
На предыдущем семинаре было описано окно сервера приложения, содержащее две кнопки (старт и стоп) и текстовое поле журнала. Необходимо вынести логику работы сервера
в класс ChatServer, а в обработчиках кнопок оставить только логику нажатия кнопки и
журналирования сообщений от сервера.
Для достижения цели необходимо описать интерфейс «слушатель сервера», с методом
«получить сообщение», вызывать его с одной стороны, и реализовать с другой. Вариант решения
*/

public class Server implements ServerListener{
    boolean isServerWorking;
    private Listener listener;

    public Server(Listener listener) {
        this.listener = listener;
        this.isServerWorking = false;
    }

    public void start() {
        if (!isServerWorking) {
            isServerWorking = true;
            listener.messageRes("Статус сервера: " + isServerWorking);
        } else {
            listener.messageRes("Сеоевер запущен");
        }

    }

    public void stop() {
        if (isServerWorking) {
            isServerWorking = false;
            listener.messageRes("Статус сервера: " + isServerWorking);
        } else {
            listener.messageRes("Сеоевер не запущен");
        }

    }


    @Override
    public void serverListener(boolean status) {

        if (status){
            stop();
        } else {
            start();
        }

    }
}
