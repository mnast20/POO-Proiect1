package child;

import input.ChildInput;

public final class Kid extends Child {
    public Kid(final ChildInput child) {
        super(child);
        calculateAverageScore();
    }

    public Kid(final Child child) {
        super(child);
        calculateAverageScore();
    }

    public void calculateAverageScore() {
        Double numerator = 0.0;
        int size = this.getNiceScoreHistory().size();

        if (size == 0) {
            this.setAverageScore(0.0);
            return;
        }

        for (Double niceScore: this.getNiceScoreHistory()) {
            numerator += niceScore;
        }
        this.setAverageScore(numerator / size);
    }
}
