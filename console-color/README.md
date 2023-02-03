# Console Color

Colorizes output of terminals supporting <a href="https://en.wikipedia.org/wiki/Color_depth#True_color_(24-bit)">True Color</a>
and uses <a href="https://en.wikipedia.org/wiki/ANSI_escape_code#24-bit">ANSI Escape sequence for 24-bit colors</a>
producing ```String``` with format like:

<code>{ESC}[38;2;{r};{g};{b}m{text}{ESC}[0m</code>

where:

* {ESC} - Unicode 1B <code></code>(the Escape character)
* {r} - red value 0-255
* {g} - green value 0-255
* {b} - blue value 0-255
* {text}$ - text to colorize

## Usage example:

```java
class UsageExample {

    void rgb() {
        Color color = ConsoleColor.RGB(173, 255, 47);
        String colorized = color.colorize("rgb(173,255,47): colorized message");
        System.out.println(colorized);
    }

    void hex() {
        Color color = ConsoleColor.HEX("#F03366");
        String colorized = color.colorize("HEX(F03366): colorized message");
        System.out.println(colorized);
    }

    void preDefined() {
        Color color = ConsoleColor.DEEP_SKY_BLUE;
        String colorized = color.colorize("HOT_PINK: colorized message");
        System.out.println(colorized);
    }

    void findColor() {
        Color color = ConsoleColor.findColor("deEp Sky_bluE");
        String colorized = color.colorize("DEEP_SKY_BLUE: colorized message");
        System.out.println(colorized);
    }

    void colorFotFound() {
        Color color = ConsoleColor.findColor("invalid color name");
        String colorized = color.colorize("not colorized message");
        System.out.println(colorized);
    }
}
```

### Terminal output:
> $\color[RGB]{173,255,47} rgb(173,255,47): colorized message$

> $\color[RGB]{240,51,102} HEX: F03366: colorized message$

> $\color[RGB]{255,105,180} HOT‗PINK: colorized message$

> $\color[RGB]{0,191,255} DEEP‗SKY‗BLUE: colorized message$

> not colorized message

## Pre-defined colors:

ConsoleColor.*

> $\color[RGB]{128,0,0} MAROON$ $\color[RGB]{139,0,0} DARK‗RED$ $\color[RGB]{165,42,42} BROWN$ $\color[RGB]{178,34,34} FIREBRICK$ $\color[RGB]{220,20,60} CRIMSON$ $\color[RGB]{255,0,0} RED$ $\color[RGB]{255,99,71} TOMATO$ $\color[RGB]{255,127,80} CORAL$ $\color[RGB]{205,92,92} INDIAN‗RED$ $\color[RGB]{240,128,128} LIGHT‗CORAL$ $\color[RGB]{233,150,122} DARK‗SALMON$ $\color[RGB]{250,128,114} SALMON$ $\color[RGB]{255,160,122} LIGHT‗SALMON$ $\color[RGB]{255,69,0} ORANGE‗RED$ $\color[RGB]{255,140,0} DARK‗ORANGE$ $\color[RGB]{255,165,0} ORANGE$ $\color[RGB]{255,215,0} GOLD$ $\color[RGB]{184,134,11} DARK‗GOLDEN‗ROD$ $\color[RGB]{218,165,32} GOLDEN‗ROD$ $\color[RGB]{238,232,170} PALE‗GOLDEN‗ROD$ $\color[RGB]{189,183,107} DARK‗KHAKI$ $\color[RGB]{240,230,140} KHAKI$ $\color[RGB]{128,128,0} OLIVE$ $\color[RGB]{255,255,0} YELLOW$ $\color[RGB]{154,205,50} YELLOW‗GREEN$ $\color[RGB]{85,107,47} DARK‗OLIVE‗GREEN$ $\color[RGB]{107,142,35} OLIVE‗DRAB$ $\color[RGB]{124,252,0} LAWN‗GREEN$ $\color[RGB]{127,255,0} CHARTREUSE$ $\color[RGB]{173,255,47} GREEN‗YELLOW$ $\color[RGB]{0,100,0} DARK‗GREEN$ $\color[RGB]{0,128,0} GREEN$ $\color[RGB]{34,139,34} FOREST‗GREEN$ $\color[RGB]{0,255,0} LIME$ $\color[RGB]{50,205,50} LIME‗GREEN$ $\color[RGB]{144,238,144} LIGHT‗GREEN$ $\color[RGB]{152,251,152} PALE‗GREEN$ $\color[RGB]{143,188,143} DARK‗SEA‗GREEN$ $\color[RGB]{0,250,154} MEDIUM‗SPRING‗GREEN$ $\color[RGB]{0,255,127} SPRING‗GREEN$ $\color[RGB]{46,139,87} SEA‗GREEN$ $\color[RGB]{102,205,170} MEDIUM‗AQUA‗MARINE$ $\color[RGB]{60,179,113} MEDIUM‗SEA‗GREEN$ $\color[RGB]{32,178,170} LIGHT‗SEA‗GREEN$ $\color[RGB]{47,79,79} DARK‗SLATE‗GRAY$ $\color[RGB]{0,128,128} TEAL$ $\color[RGB]{0,139,139} DARK‗CYAN$ $\color[RGB]{0,255,255} AQUA$ $\color[RGB]{0,255,255} CYAN$ $\color[RGB]{224,255,255} LIGHT‗CYAN$ $\color[RGB]{0,206,209} DARK‗TURQUOISE$ $\color[RGB]{64,224,208} TURQUOISE$ $\color[RGB]{72,209,204} MEDIUM‗TURQUOISE$ $\color[RGB]{175,238,238} PALE‗TURQUOISE$ $\color[RGB]{127,255,212} AQUA‗MARINE$ $\color[RGB]{176,224,230} POWDER‗BLUE$ $\color[RGB]{95,158,160} CADET‗BLUE$ $\color[RGB]{70,130,180} STEEL‗BLUE$ $\color[RGB]{100,149,237} CORN‗FLOWER‗BLUE$ $\color[RGB]{0,191,255} DEEP‗SKY‗BLUE$ $\color[RGB]{30,144,255} DODGER‗BLUE$ $\color[RGB]{173,216,230} LIGHT‗BLUE$ $\color[RGB]{135,206,235} SKY‗BLUE$ $\color[RGB]{135,206,250} LIGHT‗SKY‗BLUE$ $\color[RGB]{25,25,112} MIDNIGHT‗BLUE$ $\color[RGB]{0,0,128} NAVY$ $\color[RGB]{0,0,139} DARK‗BLUE$ $\color[RGB]{0,0,205} MEDIUM‗BLUE$ $\color[RGB]{0,0,255} BLUE$ $\color[RGB]{65,105,225} ROYAL‗BLUE$ $\color[RGB]{138,43,226} BLUE‗VIOLET$ $\color[RGB]{75,0,130} INDIGO$ $\color[RGB]{72,61,139} DARK‗SLATE‗BLUE$ $\color[RGB]{106,90,205} SLATE‗BLUE$ $\color[RGB]{123,104,238} MEDIUM‗SLATE‗BLUE$ $\color[RGB]{147,112,219} MEDIUM‗PURPLE$ $\color[RGB]{139,0,139} DARK‗MAGENTA$ $\color[RGB]{148,0,211} DARK‗VIOLET$ $\color[RGB]{153,50,204} DARK‗ORCHID$ $\color[RGB]{186,85,211} MEDIUM‗ORCHID$ $\color[RGB]{128,0,128} PURPLE$ $\color[RGB]{216,191,216} THISTLE$ $\color[RGB]{221,160,221} PLUM$ $\color[RGB]{238,130,238} VIOLET$ $\color[RGB]{255,0,255} MAGENTA$ $\color[RGB]{218,112,214} ORCHID$ $\color[RGB]{199,21,133} MEDIUM‗VIOLET‗RED$ $\color[RGB]{219,112,147} PALE‗VIOLET‗RED$ $\color[RGB]{255,20,147} DEEP‗PINK$ $\color[RGB]{255,105,180} HOT‗PINK$ $\color[RGB]{255,182,193} LIGHT‗PINK$ $\color[RGB]{255,192,203} PINK$ $\color[RGB]{250,235,215} ANTIQUE‗WHITE$ $\color[RGB]{245,245,220} BEIGE$ $\color[RGB]{255,228,196} BISQUE$ $\color[RGB]{255,235,205} BLANCHED‗ALMOND$ $\color[RGB]{245,222,179} WHEAT$ $\color[RGB]{255,248,220} CORN‗SILK$ $\color[RGB]{255,250,205} LEMON‗CHIFFON$ $\color[RGB]{250,250,210} LIGHT‗GOLDEN‗ROD‗YELLOW$ $\color[RGB]{255,255,224} LIGHT‗YELLOW$ $\color[RGB]{139,69,19} SADDLE‗BROWN$ $\color[RGB]{160,82,45} SIENNA$ $\color[RGB]{210,105,30} CHOCOLATE$ $\color[RGB]{205,133,63} PERU$ $\color[RGB]{244,164,96} SANDY‗BROWN$ $\color[RGB]{222,184,135} BURLY‗WOOD$ $\color[RGB]{210,180,140} TAN$ $\color[RGB]{188,143,143} ROSY‗BROWN$ $\color[RGB]{255,228,181} MOCCASIN$ $\color[RGB]{255,222,173} NAVAJO‗WHITE$ $\color[RGB]{255,218,185} PEACH‗PUFF$ $\color[RGB]{255,228,225} MISTY‗ROSE$ $\color[RGB]{255,240,245} LAVENDER‗BLUSH$ $\color[RGB]{250,240,230} LINEN$ $\color[RGB]{253,245,230} OLD‗LACE$ $\color[RGB]{255,239,213} PAPAYA‗WHIP$ $\color[RGB]{255,245,238} SEA‗SHELL$ $\color[RGB]{245,255,250} MINT‗CREAM$ $\color[RGB]{112,128,144} SLATE‗GRAY$ $\color[RGB]{119,136,153} LIGHT‗SLATE‗GRAY$ $\color[RGB]{176,196,222} LIGHT‗STEEL‗BLUE$ $\color[RGB]{230,230,250} LAVENDER$ $\color[RGB]{255,250,240} FLORAL‗WHITE$ $\color[RGB]{240,248,255} ALICE‗BLUE$ $\color[RGB]{248,248,255} GHOST‗WHITE$ $\color[RGB]{240,255,240} HONEYDEW$ $\color[RGB]{255,255,240} IVORY$ $\color[RGB]{240,255,255} AZURE$ $\color[RGB]{255,250,250} SNOW$ $\color[RGB]{0,0,0} BLACK$ $\color[RGB]{105,105,105} DIM‗GRAY$ $\color[RGB]{128,128,128} GRAY$ $\color[RGB]{169,169,169} DARK‗GRAY$ $\color[RGB]{192,192,192} SILVER$ $\color[RGB]{211,211,211} LIGHT‗GRAY$ $\color[RGB]{220,220,220} GAINSBORO$ $\color[RGB]{245,245,245} WHITE‗SMOKE$ $\color[RGB]{255,255,255} WHITE$
