package child;

import input.ChildInput;

public final class Baby extends Child {
    public static final Double MAXIMUM_SCORE = 10.0;

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
     * Method calculating a baby's average nice score
     */
    public void calculateAverageScore() {
        // baby's average nice score is always set as 10
        this.setAverageScore(MAXIMUM_SCORE);
    }
}
