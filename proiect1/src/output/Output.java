package output;

import child.AnnualChildren;

import java.util.ArrayList;

public final class Output {
    private ArrayList<AnnualChildren> annualChildren = new ArrayList<>();

    public Output() { }

    public Output(final ArrayList<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public ArrayList<AnnualChildren> getAnnualChildren() {
        return annualChildren;
    }

    public void addAnnualChildren(final AnnualChildren newAnnualChildren) {
        this.annualChildren.add(newAnnualChildren);
    }
}
