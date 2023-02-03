package art.yszu.utils.consolecolor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleColorTest {

    private static final int CORRECT_VALUE = 0;
    private static final int TOO_LOW_VALUE = -1;
    private static final int TOO_HIGH_VALUE = 256;

    @Test
    void RGB_rTooLow() {
        assertThrows(IllegalArgumentException.class, () ->
                ConsoleColor.RGB(TOO_LOW_VALUE, CORRECT_VALUE, CORRECT_VALUE));
    }

    @Test
    void RGB_gTooLow() {
        assertThrows(IllegalArgumentException.class, () ->
                ConsoleColor.RGB(CORRECT_VALUE, TOO_LOW_VALUE, CORRECT_VALUE));
    }

    @Test
    void RGB_bTooLow() {
        assertThrows(IllegalArgumentException.class, () ->
                ConsoleColor.RGB(CORRECT_VALUE, CORRECT_VALUE, TOO_LOW_VALUE));
    }

    @Test
    void RGB_rTooHigh() {
        assertThrows(IllegalArgumentException.class, () ->
                ConsoleColor.RGB(TOO_HIGH_VALUE, CORRECT_VALUE, CORRECT_VALUE));
    }

    @Test
    void RGB_gTooHigh() {
        assertThrows(IllegalArgumentException.class, () ->
                ConsoleColor.RGB(CORRECT_VALUE, TOO_HIGH_VALUE, CORRECT_VALUE));
    }

    @Test
    void RGB_bTooHigh() {
        assertThrows(IllegalArgumentException.class, () ->
                ConsoleColor.RGB(CORRECT_VALUE, CORRECT_VALUE, TOO_HIGH_VALUE));
    }

    @Test
    void RGB_correct() {
        Color rgb = ConsoleColor.RGB(CORRECT_VALUE, CORRECT_VALUE, CORRECT_VALUE);
        assertNotNull(rgb);
    }

    @Test
    void HEX_incorrect() {
        assertThrows(IllegalArgumentException.class,()->
                ConsoleColor.HEX("#fffffG"));
    }

    @Test
    void HEX() {
        assertEquals("rgb(240,51,102)", ConsoleColor.HEX("#F03366").toString());
        assertEquals("rgb(0,0,0)", ConsoleColor.HEX("#000000").toString());
        assertEquals("rgb(255,255,255)", ConsoleColor.HEX("#FFFFFF").toString());
    }

    @Test
    void testToString() {
        //given
        Color color = ConsoleColor.GREEN;

        //when
        String string = color.toString();

        //then
        assertEquals("GREEN", string);
    }

    @Test
    void colorize() {
        //given
        Color color = ConsoleColor.YELLOW;

        //when
        String colorized = color.colorize("text");

        //then
        assertEquals("\u001b[38;2;255;255;0mtext\u001b[0m", colorized);

    }

    @Test
    void fromStringNotFound() {
        //when
        Color color = ConsoleColor.findColor("invalid color name");

        //then
        assertEquals("", color.toString());
        assertEquals("text", color.colorize("text"));
    }


    @Test
    void fromString() {
        //when
        Color color = ConsoleColor.findColor("red");

        //then
        assertEquals("RED", color.toString());
        assertEquals("\u001b[38;2;255;0;0mtext\u001b[0m", color.colorize("text"));
    }

    @Test
    void values() {
        //when
        ConsoleColor[] values = ConsoleColor.values();

        //then
        assertEquals(139, values.length);
    }
}