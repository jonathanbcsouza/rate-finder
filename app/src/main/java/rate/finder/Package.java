package rate.finder;

public class Package {

    private int maxLength;
    private int maxBreadth;
    private int maxHeight;
    private double price;

    public Package(int length, int breadth, int height, double price) {
        this.maxLength = length;
        this.maxBreadth = breadth;
        this.maxHeight = height;
        this.price = price;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxBreadth() {
        return maxBreadth;
    }

    public void setMaxBreadth(int maxBreadth) {
        this.maxBreadth = maxBreadth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
