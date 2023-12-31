package src;

public class Rectangle implements Shape {

    private double width;
    private double height;

    Rectangle (double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double computeArea(){
        return this.height * this.width;
    }
}
