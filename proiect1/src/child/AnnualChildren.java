package child;

import java.util.ArrayList;

public final class AnnualChildren {
    private final ArrayList<Child> children = new ArrayList<>();

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void addChildrenList(final ArrayList<Child> childrenList) {
        for (Child child: childrenList) {
            children.add(new Child(child));
        }
    }
}
