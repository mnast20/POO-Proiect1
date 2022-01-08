package input;

import enums.Category;

import java.util.ArrayList;

public final class ChildUpdate {
    private Integer id;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences;

    public Integer getId() {
        return id;
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

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}
