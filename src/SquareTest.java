package src;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

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
}