package hw3;

public class MyCheckStringNameException extends RuntimeException {
    public MyCheckStringNameException() {
        super("Некорректный ввод ФИО! ");
    }
}
