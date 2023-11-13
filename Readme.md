# Test Driven Development Examination

## Report

### Step 1: Implement area calculator

Initially we created an empty class called `Rectangle`, then we created tests which we were expecting to be fixed. Here is the tests we added:

```java
    @Test
    @DisplayName("Validate simple area calculation")
    void computeAreaSample1() {
        Rectangle rectangle = new Rectangle(2, 3);
        assertEquals(2 * 3, rectangle.computeArea());
    }

    @Test
    @DisplayName("Validate simple area calculation 2")
    void computeAreaSample2() {
        Rectangle rectangle = new Rectangle(1.1, 2.2);
        assertEquals(1.1 * 2.2, rectangle.computeArea());
    }
```
Then we added rectangle constructor and `computeArea` function in a way that it met our needs. The following code displays what was implemented in rectangle class:

```java
    private double width;
    private double height;

    Rectangle (double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double computeArea(){
        return this.height * this.width;
    }
```

### Step 2: Add getter/setter for rectangle class

We added some tests regarding constructor check and setter check as well. We also added another test for checking the area after using setter functions:

```java
    @Test
    @DisplayName("Validate initial get height check")
    void checkInitialHeightGet() {
        Rectangle rectangle = new Rectangle(12, 15);
        assertEquals(15, rectangle.getHeight());
    }

    @Test
    @DisplayName("Validate initial get width check")
    void checkInitialWidthGet() {
        Rectangle rectangle = new Rectangle(12, 15);
        assertEquals(12, rectangle.getWidth());
    }

    @Test
    @DisplayName("Validate set height check")
    void checkHeightSet() {
        Rectangle rectangle = new Rectangle(12, 15);
        rectangle.setHeight(22);
        assertEquals(22, rectangle.getHeight());
    }

    @Test
    @DisplayName("Validate set width check")
    void checkWidthSet() {
        Rectangle rectangle = new Rectangle(12, 15);
        rectangle.setWidth(32);
        assertEquals(32, rectangle.getWidth());
    }

    @Test
    @DisplayName("Validate area after modification")
    void checkAreaAfterSet() {
        Rectangle rectangle = new Rectangle(4, 3);
        rectangle.setWidth(5);
        rectangle.setHeight(6);
        assertEquals(5 * 6, rectangle.computeArea());
    }
```

Then we added needed getters and setters in order to meet the needs:

```java
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
```

### Step 3: Handle square

Initially in this step we knew that it is not a correct decision for square to inherit rectangle because it ruins some of SOLID principles like LCP or OCP because square has to change setter logic which is not a correct approach. So, we added an interface called `Shape` like this:

```java
package src;

public interface Shape {
    public double computeArea();
}
```

Then we added some tests for square to check all the needs:

```java
    @Test
    @DisplayName("Validate simple area calculation")
    void computeAreaSample() {
        Square square = new Square(2);
        assertEquals(2 * 2, square.computeArea());
    }

    @Test
    @DisplayName("Validate initial get side check")
    void checkInitialSideGet() {
        Square square = new Square(3);
        assertEquals(3, square.getSide());
    }

    @Test
    @DisplayName("Validate set side check")
    void checkSideSet() {
        Square square = new Square(4);
        square.setSide(5);
        assertEquals(5, square.getSide());
    }

    @Test
    @DisplayName("Validate area after modification")
    void checkAreaAfterSet() {
        Square square = new Square(6);
        square.setSide(7);
        assertEquals(7 * 7, square.computeArea());
    }
```

Then we changed our code in a way that meet our needs and we also change rectangle class in order to implement shape interface. Then we re-run rectangle tests to check if logic is stable yet or not. The following code displays `Square` class implementation:

```java
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
```

## Questions

### 1
For testing a software we have several types of tests in this way:
- Unit Testing
- Integration Testing
- System Testing
- Functional Testing
- Acceptance Testing
- Smoke Testing
- Regression Testing
- Performance Testing
- Security Testing
- User Acceptance Testing

So the answer is no, because TDD is a software development practice which only covers `Unit testing` section between different test types not a software testing practice. We should write other types of tests like integration tests and end-to-end tests in test phase of software development life cycle.

### 2

Granularity means how isolated or integrated the test is. For example `unit tests` are the most isolated tests which only cover the code base and specifically some functions are each test's target. After that we have integration tests where we test a number of components in our system which covers more various parts of project and their collaboration.In the last layer we have end-to-end tests where we test the whole system based on our requirements for which we define separate roles in our company.

### 3

Not necessarily. For example end-to-end tests should be written by other people to make sure we meet the requirements, in order to have a commitment to all types of testing we usually gather different people with different skills, like Automation engineer, QA, Software test engineer, ... . So, There are other types of tests that require specialists like Regression tests, Performance tests, Security tests and Usability tests.

### 4

SOLID principles are mainly used in design phase because that's when we create overall architecture of the system and classes to be implemented. We could also use them in construction and deployment phases because we need to change code and SOLID helps us keep our code base clean.

### 5

Yes because the main problem with inheritance in this problem is that when we change height in square it also changes width. When we make the object immutable this problem won't happen and therefore inheritance is appropriate choice. Actually this answer is consistent when we made sure that the project scope and requirements won't change later. So, if we knew that we will have some changes later, then we couldn't inherit square from square as well.