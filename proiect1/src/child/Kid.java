package child;

import child.visitor.ChildVisitor;
import child.visitor.Visitor;
import input.ChildInput;

public final class Kid extends Child {
    /**
     * Kid copy constructor based on a child's input data
     */
    public Kid(final ChildInput child) {
        super(child);
        calculateAverageScore();
    }

    /**
     * Kid copy constructor based on another child
     */
    public Kid(final Child child) {
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
     * Method calculating a kid's average nice score
     */
    public void calculateAverageScore() {
        Visitor visitor = new ChildVisitor();
        this.accept(visitor);
    }
}
