package database;

import child.Child;
import child.Baby;
import child.Kid;
import child.Teen;
import child.ChildUtil;
import common.ChildAge;
import gift.Gift;
import input.ChildInput;
import input.GiftInput;
import input.Input;

import java.util.ArrayList;

public final class SantaDatabase {
    private Integer numberOfYears;
    private Double santaBudget;
    private Double budgetUnit;
    private final ArrayList<Child> children = new ArrayList<>();
    private final ArrayList<Gift> santaGiftsList = new ArrayList<>();

    private static SantaDatabase instance;

    private SantaDatabase() { }

    /**
     * Lazy Singleton Santa Database
     */
    public static SantaDatabase getSantaDatabase() {
        if (instance == null) {
            instance = new SantaDatabase();
        }
        return instance;
    }

    /**
     * Method calculating the value of a budget unit
     */
    public void calculateBudgetUnit() {
        Double sumAllScores = 0.0;

        // calculate sum of children's average grades
        for (Child child: children) {
            sumAllScores += child.getAverageScore();
        }

        // get budget unit value
        budgetUnit = santaBudget / sumAllScores;
    }

    /**
     * Method adding children to the Santa Database
     */
    public void addChildren(final ArrayList<ChildInput> inputChildren) {
        for (ChildInput child: inputChildren) {
            if (child.getAge() < ChildAge.KID_YEARS_START) {
                children.add(new Baby(child));
            } else if (child.getAge() < ChildAge.TEEN_YEARS_START) {
                children.add(new Kid(child));
            } else if (child.getAge() <= ChildAge.TEEN_YEARS_FINAL) {
                children.add(new Teen(child));
            }
        }
    }

    /**
     * Method adding gifts to the Santa Database
     */
    public void addGifts(final ArrayList<GiftInput> inputGifts) {
        for (GiftInput gift: inputGifts) {
            santaGiftsList.add(new Gift(gift));
        }
    }

    /**
     * Method adding input data to the Santa Database
     */
    public void addDataFromInput(final Input input) {
        // get santa budget and number of years
        this.numberOfYears = input.getNumberOfYears();
        this.santaBudget = input.getSantaBudget();

        // add children and gifts to the Database
        this.addChildren(input.getInitialData().getChildren());
        this.addGifts(input.getInitialData().getSantaGiftsList());

        // calculate the budget unit and every child's assigned budget
        calculateBudgetUnit();
        new ChildUtil().calculateAssignedBudgetChildren(children);
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public Double getBudgetUnit() {
        return budgetUnit;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public ArrayList<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * Method clearing all the children's received gifts
     */
    public void clearAllReceivedGifts() {
        for (Child child: children) {
            child.clearReceivedGifts();
        }
    }

    /**
     * Method clearing the Santa Database
     */
    public void clear() {
        instance = null;
    }
}
