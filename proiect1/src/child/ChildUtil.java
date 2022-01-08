package child;

import common.ChildAge;
import database.SantaDatabase;

import java.util.ArrayList;
import java.util.Objects;

public final class ChildUtil {
    /**
     * Method finding a child based on a given id
     */
    public Child findChildBasedOnId(final Integer id) {
        for (Child child: SantaDatabase.getSantaDatabase().getChildren()) {
            // check if a child has the same id as the child update's id
            if (Objects.equals(id, child.getId())) {
                return child;
            }
        }

        return null;
    }

    /**
     * Method aging all children from a given list of children
     */
    public void ageChildren(final ArrayList<Child> children) {
        for (int i = 0; i < children.size(); i++) {
            Child child = children.get(i);

            // increment child's age
            child.age();

            if (child.getAge().equals(ChildAge.KID_YEARS_START)) {
                // Baby turns into a Kid
                children.set(i, new Kid(child));
            } else if (child.getAge().equals(ChildAge.TEEN_YEARS_START)) {
                // Kid turns into a Teen
                children.set(i, new Teen(child));
            }
        }
    }

    /**
     * Method removing all the adults from a list of children
     */
    public void removeAdults(final ArrayList<Child> children) {
        children.removeIf((child -> child.getAge() > ChildAge.TEEN_YEARS_FINAL));
    }

    /**
     * Method calculating assigned budgets for a list of children
     */
    public void calculateAssignedBudgetChildren(final ArrayList<Child> children) {
        for (Child child: children) {
            child.calculateSantaBudget();
        }
    }
}
