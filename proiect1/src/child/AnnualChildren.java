package child;

import java.util.ArrayList;

public final class AnnualChildren {
    private final ArrayList<Child> children = new ArrayList<>();

    public ArrayList<Child> getChildren() {
        return children;
    }

    /**
     * Method for deep copying a list
     */
    public void addChildrenList(final ArrayList<Child> childrenList) {
        for (Child child: childrenList) {
            // create a copy of child and add copy to the list
            children.add(new Child(child));
        }
    }
}
