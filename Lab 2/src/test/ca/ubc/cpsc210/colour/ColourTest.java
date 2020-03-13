package ca.ubc.cpsc210.colour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ColourTest {
    private Colour red;
    private Colour green;
    private Colour blue;

    private Colour grey;

    @BeforeEach
    void runBefore() {
        red = new Colour(255, 0, 0);
        green = new Colour(0, 255, 0);
        blue = new Colour(0, 0, 255);

        grey = new Colour(128, 128, 128);
    }

    @Test
    void testIsGreyScale() {
        assertTrue(grey.isGreyScale());

        assertFalse(red.isGreyScale());
        assertFalse(green.isGreyScale());
        assertFalse(blue.isGreyScale());


    }

    @Test
    void testToHex() {
        assertEquals("ff0000", red.toHex());
        assertEquals("ff00", green.toHex());
        assertEquals("ff", blue.toHex());

        assertEquals("808080", grey.toHex());

    }
}