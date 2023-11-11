package src;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

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
}