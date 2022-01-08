package child;

import child.visitor.ChildVisitor;
import child.visitor.Visitor;
import input.ChildInput;

public final class Baby extends Child {
    /**
     * Baby copy constructor based on a child's input data
     */
    public Baby(final ChildInput child) {
        super(child);
        calculateAverageScore();
    }

    /**
     * Baby copy constructor based on another child
     */
    public Baby(final Child child) {
        super(child);
        calculateAverageScore();
    }

    /**
     * Method accepting a visitor and allowing it to visit
     */
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * Method calculating a baby's average nice score
     */
    public void calculateAverageScore() {
        Visitor visitor = new ChildVisitor();
        this.accept(visitor);
    }
}
