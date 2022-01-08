package gift;

import child.Child;
import database.SantaDatabase;
import enums.Category;

import java.util.ArrayList;

public final class GiftUtil {
    public Gift findGiftMinPrice(final ArrayList<Gift> gifts) {
        if (gifts == null || gifts.size() == 0) {
            return null;
        }

        Gift giftMinPrice = gifts.get(0);

        for (Gift gift: gifts) {
            if (gift.getPrice() < giftMinPrice.getPrice()) {
                giftMinPrice = gift;
            }
        }

        return giftMinPrice;
    }

    public ArrayList<Gift> findGiftsInCategory(final Category category,
                                               final ArrayList<Gift> gifts) {
        ArrayList<Gift> giftsInCategory = new ArrayList<>();

        for (Gift gift: gifts) {
            if (gift.getCategory() == category) {
                giftsInCategory.add(gift);
            }
        }

        return giftsInCategory;
    }

    /**
     * Method distributing gifts a given child
     */
    public void distributeGiftsChild(final Child child) {
        Double childSantaBudget = child.getAssignedBudget();
        ArrayList<Gift> allGifts = SantaDatabase.getSantaDatabase().getSantaGiftsList();
        ArrayList<Category> giftsPreferences = child.getGiftsPreferences();

        for (Category category: giftsPreferences) {
            Gift foundGift = findGiftMinPrice(findGiftsInCategory(category, allGifts));

            if (foundGift != null) {
                if (foundGift.getPrice() < childSantaBudget) {
                    child.getReceivedGifts().add(foundGift);
                    childSantaBudget -= foundGift.getPrice();
                }
            }
        }
    }

    public void distributeGiftsAllChildren() {
        ArrayList<Child> allChildren = SantaDatabase.getSantaDatabase().getChildren();

        for (Child child: allChildren) {
            distributeGiftsChild(child);
        }
    }
}
