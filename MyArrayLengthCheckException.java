package hw3;

public class MyArrayLengthCheckException extends RuntimeException {
    public MyArrayLengthCheckException() {
        super(String.format("Введено неверное колличество данных!"));
    }
}
