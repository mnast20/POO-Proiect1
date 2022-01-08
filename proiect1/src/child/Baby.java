package child;

import input.ChildInput;

public final class Baby extends Child {
    public static final Double MAXIMUM_SCORE = 10.0;

    public Baby(final ChildInput child) {
        super(child);
        calculateAverageScore();
    }

    public Baby(final Child child) {
        super(child);
        calculateAverageScore();
    }

    public void calculateAverageScore() {
        this.setAverageScore(MAXIMUM_SCORE);
    }
}
