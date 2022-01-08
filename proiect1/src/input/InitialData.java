package input;

import java.util.ArrayList;

public final class InitialData {
    private ArrayList<ChildInput> children;
    private ArrayList<GiftInput> santaGiftsList;

    public ArrayList<ChildInput> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<ChildInput> children) {
        this.children = children;
    }

    public ArrayList<GiftInput> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final ArrayList<GiftInput> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
