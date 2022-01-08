package round;

import child.AnnualChildren;
import database.SantaDatabase;
import gift.GiftUtil;
import input.AnnualChange;
import output.Output;
import year.Year;

import java.util.ArrayList;

public final class Round {
    /**
     * Method executing a year round
     */
    public AnnualChildren executeRound(final AnnualChange annualChange) {
        if (annualChange != null) {
            // annual changes are requested and the round isn't the same as round0
            new Year().change(annualChange);
        }

        // distribute gifts to children
        new GiftUtil().distributeGiftsAllChildren();

        // add children to the annual children's list
        AnnualChildren annualChildren = new AnnualChildren();
        annualChildren.addChildrenList(SantaDatabase.getSantaDatabase().getChildren());

        // clear children's received gifts
        SantaDatabase.getSantaDatabase().clearAllReceivedGifts();

        return annualChildren;
    }

    /**
     * Method solving year rounds and creating the output
     */
    public Output solveRounds(final ArrayList<AnnualChange> annualChanges) {
        Output output = new Output();

        // execute round0
        AnnualChildren annualChildren = executeRound(null);
        // add the children from round0 to output
        output.addAnnualChildren(annualChildren);

        // execute new year rounds
        for (int i = 0; i < SantaDatabase.getSantaDatabase().getNumberOfYears(); i++) {
            AnnualChange annualChange = annualChanges.get(i);
            // execute new year round
            annualChildren = executeRound(annualChange);
            // add annual children to output
            output.addAnnualChildren(annualChildren);
        }

        return output;
    }
}
