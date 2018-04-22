package rate.finder;

public class Package {

    private int length ;
    private int breadth ;
    private int heigth ;
    private double price ;

    public Package(int length, int breadth, int height, double price) {
        this.length = length;
        this.breadth = breadth;
        this.heigth = height;
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
