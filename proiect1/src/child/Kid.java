package child;

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
     * Method calculating a kid's average nice score
     */
    public void calculateAverageScore() {
        Double numerator = 0.0;
        int size = this.getNiceScoreHistory().size();

        if (size == 0) {
            this.setAverageScore(0.0);
            return;
        }

        // calculate arithmetic average score of the nice score history list
        for (Double niceScore: this.getNiceScoreHistory()) {
            numerator += niceScore;
        }
        this.setAverageScore(numerator / size);
    }
}
