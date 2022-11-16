package Opgave3;

public class PercentDiscount extends Discount{
    private double discountPercentage;
    public PercentDiscount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getDiscount(double price) {
        return (1-(discountPercentage/100))*price;
    }
}
