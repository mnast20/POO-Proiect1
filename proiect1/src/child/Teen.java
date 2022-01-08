package child;

import input.ChildInput;

public final class Teen extends Child {
    /**
     * Teen copy constructor based on a child's input data
     */
    public Teen(final ChildInput child) {
        super(child);
        calculateAverageScore();
    }

    /**
     * Teen copy constructor based on another child
     */
    public Teen(final Child child) {
        super(child);
        calculateAverageScore();
    }

    /**
     * Method calculating a teen's average nice score
     */
    public void calculateAverageScore() {
        Double i = 1.0;
        double numerator = 0.0;
        double denominator = 0.0;

        this.setAverageScore(0.0);

        // calculate weighted average score of the nice score history list
        for (Double niceScore: this.getNiceScoreHistory()) {
            numerator += niceScore * i;
            denominator += i;
            i += 1.0;
        }

        if (denominator != 0.0) {
            this.setAverageScore(numerator / denominator);
        }
    }
}
