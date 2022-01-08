package gift;

import enums.Category;
import input.GiftInput;

public final class Gift {
    private final String productName;
    private final Double price;
    private final Category category;

    /**
     * Gift copy constructor based on a gift's input data
     */
    public Gift(final GiftInput gift) {
        this.productName = gift.getProductName();
        this.price = gift.getPrice();
        this.category = gift.getCategory();
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
