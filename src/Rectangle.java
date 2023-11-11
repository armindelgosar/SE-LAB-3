package src;

public class Rectangle {
    private double width;
    private double height;
    Rectangle (double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public double computeArea(){
        return this.height * this.width;
    }
}
