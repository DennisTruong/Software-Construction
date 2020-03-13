package ca.ubc.cpsc210.colour;

// Represents a colour having a red, green and blue component,
// each of which is in the range [0, 255]
public class Colour {
    private int red;
    private int green;
    private int blue;

    // EFFECTS: constructs the colour (r, g, b)
    Colour(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this. blue = b;

    }

    // EFFECTS: returns true if this colour is on the grey scale,
    // false otherwise
    boolean isGreyScale() {
        if (this.red == this.green && this.green == this.blue) {
            return true;
        } else {
            return false;
        }
    }
    // EFFECTS: returns the hexadecimal representation of this colour
    String toHex() {
        int combinedInteger;
        String hexString;
        combinedInteger = (this.red * 256 +  this.green) * 256 + this.blue;
        hexString = Integer.toHexString(combinedInteger);

        return hexString;
    }
}
