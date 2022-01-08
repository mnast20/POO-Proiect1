package child.visitor;

import child.Baby;
import child.Kid;
import child.Teen;

public interface Visitor {
    /**
     * Method visiting and calculating the Baby's average nice score
     */
    void visit(Baby baby);

    /**
     * Method visiting and calculating the Kid's average nice score
     */
    void visit(Kid kid);

    /**
     * Method visiting and calculating the Teen's average nice score
     */
    void visit(Teen teen);
}
