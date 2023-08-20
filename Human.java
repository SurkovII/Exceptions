package hw3;

public class Human {
    String surName;
    String name;
    String patronymic;
    String burthDate;
    String phoneNumber;
    String gender;
    public Human(String surName, String name, String patronymic, String burthDate, String phoneNumber, String gender) {
        this.name = name;
        this.surName = surName;
        this.patronymic = patronymic;
        this.burthDate = burthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>", surName, name, patronymic, burthDate, phoneNumber, gender );
    }

}
