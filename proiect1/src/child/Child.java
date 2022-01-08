package child;

import database.SantaDatabase;
import enums.Category;
import enums.Cities;
import gift.Gift;
import input.ChildInput;
import input.ChildUpdate;

import java.util.ArrayList;
import java.util.ListIterator;

public class Child {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final Cities city;
    private Integer age;
    private final ArrayList<Category> giftsPreferences;
    private Double averageScore;
    private final ArrayList<Double> niceScoreHistory;
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts;

    public Child(final ChildInput child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.city = child.getCity();
        this.age = child.getAge();
        this.giftsPreferences = child.getGiftsPreferences();
        this.averageScore = 0.0;
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.add(child.getNiceScore());
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
    }

    public Child(final Child child) {
        this.id = child.id;
        this.lastName = child.lastName;
        this.firstName = child.firstName;
        this.city = child.city;
        this.age = child.age;
        this.giftsPreferences = new ArrayList<>(child.giftsPreferences);
        this.averageScore = child.averageScore;
        this.niceScoreHistory = new ArrayList<>(child.niceScoreHistory);
        this.assignedBudget = child.assignedBudget;
        this.receivedGifts = new ArrayList<>(child.receivedGifts);
    }

    public final Integer getId() {
        return id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final Cities getCity() {
        return city;
    }

    public final Integer getAge() {
        return age;
    }

    public final ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final Double getAssignedBudget() {
        return assignedBudget;
    }

    public final ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public final void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public void calculateAverageScore() {
        averageScore = 0.0;
    }

    public void calculateSantaBudget() {
        assignedBudget = SantaDatabase.getSantaDatabase().getBudgetUnit() * averageScore;
    }

    public void age() {
        age++;
    }

    public int searchCategory(final Category searchedCategory) {
        int i = 0;
        for (Category category: giftsPreferences) {
            if (searchedCategory == category) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void addNiceScore(final Double niceScore) {
        if (niceScore == null) {
            return;
        }
        niceScoreHistory.add(niceScore);
        this.calculateAverageScore();
    }

    public void addGiftPreferences(final ArrayList<Category> newGiftPreferences) {
        if (newGiftPreferences == null) {
            return;
        }

        ListIterator<Category> categoryIterator =
                newGiftPreferences.listIterator(newGiftPreferences.size());

        while (categoryIterator.hasPrevious()) {
            Category category = categoryIterator.previous();
            int foundCategory = this.searchCategory(category);

            if (foundCategory != 0) {
                giftsPreferences.add(0, category);
                if (foundCategory != -1) {
                    giftsPreferences.remove(foundCategory + 1);
                }
            }
        }
    }

    public void applyUpdate(final ChildUpdate update) {
        this.addNiceScore(update.getNiceScore());
        this.addGiftPreferences(update.getGiftsPreferences());
    }

    public void clearReceivedGifts() {
        receivedGifts = new ArrayList<>();
    }
}
