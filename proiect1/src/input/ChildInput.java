package input;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;

public final class ChildInput {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Cities city;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences;

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}
