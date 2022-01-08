package child;

import common.ChildAge;
import database.SantaDatabase;

import java.util.ArrayList;
import java.util.Objects;

public final class ChildUtil {
    public Child findChildBasedOnId(final Integer id) {
        for (Child child: SantaDatabase.getSantaDatabase().getChildren()) {
            if (Objects.equals(id, child.getId())) {
                return child;
            }
        }

        return null;
    }

    public void ageChildren(final ArrayList<Child> children) {
        for (int i = 0; i < children.size(); i++) {
            Child child = children.get(i);

            child.age();

            if (child.getAge().equals(ChildAge.KID_YEARS_START)) {
                children.set(i, new Kid(child));
            } else if (child.getAge().equals(ChildAge.TEEN_YEARS_START)) {
                children.set(i, new Teen(child));
            }
        }
    }

    public void removeAdults(final ArrayList<Child> children) {
        children.removeIf((child -> child.getAge() > ChildAge.TEEN_YEARS_FINAL));
    }

    public void calculateAssignedBudgetChildren(final ArrayList<Child> children) {
        for (Child child: children) {
            child.calculateSantaBudget();
        }
    }
}
