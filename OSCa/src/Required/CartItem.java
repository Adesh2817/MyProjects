package Required;

public class CartItem {
    private int productId;
    private int quantity;

    // Constructor to initialize productId and quantity
    public CartItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
