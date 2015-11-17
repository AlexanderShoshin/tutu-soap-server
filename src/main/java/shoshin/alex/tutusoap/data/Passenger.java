package shoshin.alex.tutusoap.data;

import java.util.Calendar;

public class Passenger {
    private String name;
    private String surname;
    private String patronymic;
    private Calendar birthDate;
    
    public Passenger(String name, String surname, String patronymic, Calendar birthDate) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
    }
    
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPatronymic() {
        return patronymic;
    }
}