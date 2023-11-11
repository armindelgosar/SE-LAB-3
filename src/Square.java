package src;

public class Square implements Shape {

    private double side;

    Square (double side) {
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double computeArea() {
        return this.side * this.side;
    }

}