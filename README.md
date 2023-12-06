# GB - Java Development Kit
## Урок 1. Графические интерфейсы
### __*Задания:*__
1. Выполнить все задания семинара, если они не были решены, 
без ограничений по времени;
2. Отправлять сообщения из текстового поля сообщения в лог 
по нажатию кнопки или по нажатию клавиши Enter на поле ввода сообщения;
3. Продублировать импровизированный лог (историю) чата в файле;
4. При запуске клиента чата заполнять поле истории из файла, 
если он существует. Обратите внимание, что чаще всего история 
сообщений хранится на сервере и заполнение истории чата 
лучше делать при соединении с сервером, а не при открытии окна клиента.
    * [Решение задания](src/main/java/ru/gb/ergakov/lesson1/lecture1/Chat/Chat.java)

## Урок 2. Программные интерфейсы
### __*Задания:*__
1. Выполнить все задания семинара, если они не были решены, 
без ограничений по времени;
2. Дописать третье задание таким образом, чтобы в идентификатор типа Developer 
   записывался объект Frontender, и далее вызывался метод developGUI(), 
   не изменяя существующие интерфейсы, только код основного класса.
   * [Решение задания](src/main/java/ru/gb/ergakov/Lesson2/seminar2/Homework2.java)

## Урок 3. Обобщенное программирование
### __*Задания:*__
1. Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким 
образом, чтобы итератор был внутренним классом и, соответственно, 
объектом в коллекции.
    * [Решение задания 1](src/main/java/ru/gb/ergakov/Lesson3/Seminar3/MegaClass.java)
2. Написать класс Калькулятор (необобщенный), который содержит обобщенные 
статические методы: sum(), multiply(), divide(), subtract(). 
Параметры этих методов – два числа разного типа, над которыми должна быть 
произведена операция.
   * [Решение задания 2](src/main/java/ru/gb/ergakov/Lesson3/homework3/Task2/Calc.java)
3. Напишите обобщенный метод compareArrays(), который принимает два массива 
и возвращает true, если они одинаковые, и false в противном случае. 
Массивы могут быть любого типа данных, но должны иметь одинаковую длину 
и содержать элементы одного типа. 

4. Напишите обобщенный класс Pair, который представляет собой пару значений 
разного типа. Класс должен иметь методы getFirst(), getSecond() для получения 
значений пары, а также переопределение метода toString(), 
возвращающее строковое представление пары.