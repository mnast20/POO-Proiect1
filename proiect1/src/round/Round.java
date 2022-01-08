package round;

import child.AnnualChildren;
import database.SantaDatabase;
import gift.GiftUtil;
import input.AnnualChange;
import output.Output;
import year.Year;

import java.util.ArrayList;

public final class Round {
    public AnnualChildren executeRound(final AnnualChange annualChange) {
        if (annualChange != null) {
            new Year().change(annualChange);
        }

        new GiftUtil().distributeGiftsAllChildren();

        AnnualChildren annualChildren = new AnnualChildren();
        annualChildren.addChildrenList(SantaDatabase.getSantaDatabase().getChildren());

        SantaDatabase.getSantaDatabase().clearAllReceivedGifts();

        return annualChildren;
    }

    public Output solveRounds(final ArrayList<AnnualChange> annualChanges) {
        Output output = new Output();

        AnnualChildren annualChildren = executeRound(null);
        output.addAnnualChildren(annualChildren);

        for (int i = 0; i < SantaDatabase.getSantaDatabase().getNumberOfYears(); i++) {
            AnnualChange annualChange = annualChanges.get(i);
            annualChildren = executeRound(annualChange);
            output.addAnnualChildren(annualChildren);
        }

        return output;
    }
}
