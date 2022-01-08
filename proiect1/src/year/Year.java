package year;

import child.Child;
import child.ChildUtil;
import database.SantaDatabase;
import input.AnnualChange;
import input.ChildUpdate;

import java.util.ArrayList;

public final class Year {
    /**
     * Method implementing a given annual change
     */
    public void change(final AnnualChange annualChange) {
        ArrayList<Child> allChildren = SantaDatabase.getSantaDatabase().getChildren();

        // replace Santa's budget with new budget
        SantaDatabase.getSantaDatabase().setSantaBudget(annualChange.getNewSantaBudget());

        // age all children from Santa Database
        new ChildUtil().ageChildren(allChildren);
        // remove adults from Santa Database
        new ChildUtil().removeAdults(allChildren);

        ArrayList<ChildUpdate> updates = annualChange.getChildrenUpdates();

        // check if there are children updates to be implemented
        if (updates.size() != 0) {
            for (ChildUpdate update: updates) {
                // find child with the same id as update's id
                Child child = new ChildUtil().findChildBasedOnId(update.getId());

                // check if child was found
                if (child != null) {
                    child.applyUpdate(update);
                }
            }
        }

        if (annualChange.getNewChildren() != null) {
            // add new children to Santa Database's list of children
            SantaDatabase.getSantaDatabase().addChildren(annualChange.getNewChildren());
        }
        if (annualChange.getNewGifts() != null) {
            // add new gifts to Santa Database's list of gifts
            SantaDatabase.getSantaDatabase().addGifts(annualChange.getNewGifts());
        }

        // calculate the new value of budget unit
        SantaDatabase.getSantaDatabase().calculateBudgetUnit();

        // calculate every child's assigned budget
        new ChildUtil().calculateAssignedBudgetChildren(allChildren);
    }
}
