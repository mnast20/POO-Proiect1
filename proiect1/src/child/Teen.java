package child;

import input.ChildInput;

public final class Teen extends Child {
    public Teen(final ChildInput child) {
        super(child);
        calculateAverageScore();
    }

    public Teen(final Child child) {
        super(child);
        calculateAverageScore();
    }

    public void calculateAverageScore() {
        Double i = 1.0;
        double numerator = 0.0;
        double denominator = 0.0;

        this.setAverageScore(0.0);

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
