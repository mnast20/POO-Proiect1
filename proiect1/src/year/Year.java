package year;

import child.Child;
import child.ChildUtil;
import database.SantaDatabase;
import input.AnnualChange;
import input.ChildUpdate;

import java.util.ArrayList;

public final class Year {
    public void change(final AnnualChange annualChange) {
        ArrayList<Child> allChildren = SantaDatabase.getSantaDatabase().getChildren();

        SantaDatabase.getSantaDatabase().setSantaBudget(annualChange.getNewSantaBudget());

        new ChildUtil().ageChildren(allChildren);
        new ChildUtil().removeAdults(allChildren);

        ArrayList<ChildUpdate> updates = annualChange.getChildrenUpdates();

        if (updates.size() != 0) {
            for (ChildUpdate update: updates) {
                Child child = new ChildUtil().findChildBasedOnId(update.getId());

                if (child != null) {
                    child.applyUpdate(update);
                }
            }
        }

        if (annualChange.getNewChildren() != null) {
            SantaDatabase.getSantaDatabase().addChildren(annualChange.getNewChildren());
        }
        if (annualChange.getNewGifts() != null) {
            SantaDatabase.getSantaDatabase().addGifts(annualChange.getNewGifts());
        }

        SantaDatabase.getSantaDatabase().calculateBudgetUnit();

        new ChildUtil().calculateAssignedBudgetChildren(allChildren);
    }
}
