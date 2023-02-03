package art.yszu.utils.consolecolor;

/**
 * ConsoleColor
 * <p>
 * Colorizes output of terminals supporting <a href="https://en.wikipedia.org/wiki/Color_depth#True_color_(24-bit)">True Color</a>
 * and uses <a href="https://en.wikipedia.org/wiki/ANSI_escape_code#24-bit">ANSI Escape sequence for 24-bit colors</a>
 * producing {@link String} with format like:
 * <p>
 * <code><span style="color: gray">{ESC}</span>[38;2;<span style="color: red">{r}</span>;<span style="color: green">{g}</span>;<span style="color: blue">{b}</span>m<span style="color: purple">{text}</span><span style="color: gray">{ESC}</span>[0m</code>
 * <p>
 * where:
 * <ul>
 *     <li><span style="color: gray">{ESC}</span> - Unicode 1B <code></code> (the Escape character) </li>
 *     <li><span style="color: red">{r}</span> - red value 0-255</li>
 *     <li><span style="color: green">{g}</span> - green value 0-255</li>
 *     <li><span style="color: blue">{b}</span> - blue value 0-255</li>
 *     <li><span style="color: purple">{text}</span> - text to colorize</li>
 * </ul>
 *
 * <p>
 * Pre-defined colors:
 * </p>
 * <span style="color: rgb(128,0,0)">         MAROON                     </span>
 * <span style="color: rgb(139,0,0)">         DARK_RED                   </span>
 * <span style="color: rgb(165,42,42)">       BROWN                      </span>
 * <span style="color: rgb(178,34,34)">       FIREBRICK                  </span>
 * <span style="color: rgb(220,20,60)">       CRIMSON                    </span>
 * <span style="color: rgb(255,0,0)">         RED                        </span>
 * <span style="color: rgb(255,99,71)">       TOMATO                     </span>
 * <span style="color: rgb(255,127,80)">      CORAL                      </span>
 * <span style="color: rgb(205,92,92)">       INDIAN_RED                 </span>
 * <span style="color: rgb(240,128,128)">     LIGHT_CORAL                </span>
 * <span style="color: rgb(233,150,122)">     DARK_SALMON                </span>
 * <span style="color: rgb(250,128,114)">     SALMON                     </span>
 * <span style="color: rgb(255,160,122)">     LIGHT_SALMON               </span>
 * <span style="color: rgb(255,69,0)">        ORANGE_RED                 </span>
 * <span style="color: rgb(255,140,0)">       DARK_ORANGE                </span>
 * <span style="color: rgb(255,165,0)">       ORANGE                     </span>
 * <span style="color: rgb(255,215,0)">       GOLD                       </span>
 * <span style="color: rgb(184,134,11)">      DARK_GOLDEN_ROD            </span>
 * <span style="color: rgb(218,165,32)">      GOLDEN_ROD                 </span>
 * <span style="color: rgb(238,232,170)">     PALE_GOLDEN_ROD            </span>
 * <span style="color: rgb(189,183,107)">     DARK_KHAKI                 </span>
 * <span style="color: rgb(240,230,140)">     KHAKI                      </span>
 * <span style="color: rgb(128,128,0)">       OLIVE                      </span>
 * <span style="color: rgb(255,255,0)">       YELLOW                     </span>
 * <span style="color: rgb(154,205,50)">      YELLOW_GREEN               </span>
 * <span style="color: rgb(85,107,47)">       DARK_OLIVE_GREEN           </span>
 * <span style="color: rgb(107,142,35)">      OLIVE_DRAB                 </span>
 * <span style="color: rgb(124,252,0)">       LAWN_GREEN                 </span>
 * <span style="color: rgb(127,255,0)">       CHARTREUSE                 </span>
 * <span style="color: rgb(173,255,47)">      GREEN_YELLOW               </span>
 * <span style="color: rgb(0,100,0)">         DARK_GREEN                 </span>
 * <span style="color: rgb(0,128,0)">         GREEN                      </span>
 * <span style="color: rgb(34,139,34)">       FOREST_GREEN               </span>
 * <span style="color: rgb(0,255,0)">         LIME                       </span>
 * <span style="color: rgb(50,205,50)">       LIME_GREEN                 </span>
 * <span style="color: rgb(144,238,144)">     LIGHT_GREEN                </span>
 * <span style="color: rgb(152,251,152)">     PALE_GREEN                 </span>
 * <span style="color: rgb(143,188,143)">     DARK_SEA_GREEN             </span>
 * <span style="color: rgb(0,250,154)">       MEDIUM_SPRING_GREEN        </span>
 * <span style="color: rgb(0,255,127)">       SPRING_GREEN               </span>
 * <span style="color: rgb(46,139,87)">       SEA_GREEN                  </span>
 * <span style="color: rgb(102,205,170)">     MEDIUM_AQUA_MARINE         </span>
 * <span style="color: rgb(60,179,113)">      MEDIUM_SEA_GREEN           </span>
 * <span style="color: rgb(32,178,170)">      LIGHT_SEA_GREEN            </span>
 * <span style="color: rgb(47,79,79)">        DARK_SLATE_GRAY            </span>
 * <span style="color: rgb(0,128,128)">       TEAL                       </span>
 * <span style="color: rgb(0,139,139)">       DARK_CYAN                  </span>
 * <span style="color: rgb(0,255,255)">       AQUA                       </span>
 * <span style="color: rgb(0,255,255)">       CYAN                       </span>
 * <span style="color: rgb(224,255,255)">     LIGHT_CYAN                 </span>
 * <span style="color: rgb(0,206,209)">       DARK_TURQUOISE             </span>
 * <span style="color: rgb(64,224,208)">      TURQUOISE                  </span>
 * <span style="color: rgb(72,209,204)">      MEDIUM_TURQUOISE           </span>
 * <span style="color: rgb(175,238,238)">     PALE_TURQUOISE             </span>
 * <span style="color: rgb(127,255,212)">     AQUA_MARINE                </span>
 * <span style="color: rgb(176,224,230)">     POWDER_BLUE                </span>
 * <span style="color: rgb(95,158,160)">      CADET_BLUE                 </span>
 * <span style="color: rgb(70,130,180)">      STEEL_BLUE                 </span>
 * <span style="color: rgb(100,149,237)">     CORN_FLOWER_BLUE           </span>
 * <span style="color: rgb(0,191,255)">       DEEP_SKY_BLUE              </span>
 * <span style="color: rgb(30,144,255)">      DODGER_BLUE                </span>
 * <span style="color: rgb(173,216,230)">     LIGHT_BLUE                 </span>
 * <span style="color: rgb(135,206,235)">     SKY_BLUE                   </span>
 * <span style="color: rgb(135,206,250)">     LIGHT_SKY_BLUE             </span>
 * <span style="color: rgb(25,25,112)">       MIDNIGHT_BLUE              </span>
 * <span style="color: rgb(0,0,128)">         NAVY                       </span>
 * <span style="color: rgb(0,0,139)">         DARK_BLUE                  </span>
 * <span style="color: rgb(0,0,205)">         MEDIUM_BLUE                </span>
 * <span style="color: rgb(0,0,255)">         BLUE                       </span>
 * <span style="color: rgb(65,105,225)">      ROYAL_BLUE                 </span>
 * <span style="color: rgb(138,43,226)">      BLUE_VIOLET                </span>
 * <span style="color: rgb(75,0,130)">        INDIGO                     </span>
 * <span style="color: rgb(72,61,139)">       DARK_SLATE_BLUE            </span>
 * <span style="color: rgb(106,90,205)">      SLATE_BLUE                 </span>
 * <span style="color: rgb(123,104,238)">     MEDIUM_SLATE_BLUE          </span>
 * <span style="color: rgb(147,112,219)">     MEDIUM_PURPLE              </span>
 * <span style="color: rgb(139,0,139)">       DARK_MAGENTA               </span>
 * <span style="color: rgb(148,0,211)">       DARK_VIOLET                </span>
 * <span style="color: rgb(153,50,204)">      DARK_ORCHID                </span>
 * <span style="color: rgb(186,85,211)">      MEDIUM_ORCHID              </span>
 * <span style="color: rgb(128,0,128)">       PURPLE                     </span>
 * <span style="color: rgb(216,191,216)">     THISTLE                    </span>
 * <span style="color: rgb(221,160,221)">     PLUM                       </span>
 * <span style="color: rgb(238,130,238)">     VIOLET                     </span>
 * <span style="color: rgb(255,0,255)">       MAGENTA                    </span>
 * <span style="color: rgb(218,112,214)">     ORCHID                     </span>
 * <span style="color: rgb(199,21,133)">      MEDIUM_VIOLET_RED          </span>
 * <span style="color: rgb(219,112,147)">     PALE_VIOLET_RED            </span>
 * <span style="color: rgb(255,20,147)">      DEEP_PINK                  </span>
 * <span style="color: rgb(255,105,180)">     HOT_PINK                   </span>
 * <span style="color: rgb(255,182,193)">     LIGHT_PINK                 </span>
 * <span style="color: rgb(255,192,203)">     PINK                       </span>
 * <span style="color: rgb(250,235,215)">     ANTIQUE_WHITE              </span>
 * <span style="color: rgb(245,245,220)">     BEIGE                      </span>
 * <span style="color: rgb(255,228,196)">     BISQUE                     </span>
 * <span style="color: rgb(255,235,205)">     BLANCHED_ALMOND            </span>
 * <span style="color: rgb(245,222,179)">     WHEAT                      </span>
 * <span style="color: rgb(255,248,220)">     CORN_SILK                  </span>
 * <span style="color: rgb(255,250,205)">     LEMON_CHIFFON              </span>
 * <span style="color: rgb(250,250,210)">     LIGHT_GOLDEN_ROD_YELLOW    </span>
 * <span style="color: rgb(255,255,224)">     LIGHT_YELLOW               </span>
 * <span style="color: rgb(139,69,19)">       SADDLE_BROWN               </span>
 * <span style="color: rgb(160,82,45)">       SIENNA                     </span>
 * <span style="color: rgb(210,105,30)">      CHOCOLATE                  </span>
 * <span style="color: rgb(205,133,63)">      PERU                       </span>
 * <span style="color: rgb(244,164,96)">      SANDY_BROWN                </span>
 * <span style="color: rgb(222,184,135)">     BURLY_WOOD                 </span>
 * <span style="color: rgb(210,180,140)">      TAN                        </span>
 * <span style="color: rgb(188,143,143)">     ROSY_BROWN                 </span>
 * <span style="color: rgb(255,228,181)">     MOCCASIN                   </span>
 * <span style="color: rgb(255,222,173)">     NAVAJO_WHITE               </span>
 * <span style="color: rgb(255,218,185)">     PEACH_PUFF                 </span>
 * <span style="color: rgb(255,228,225)">     MISTY_ROSE                 </span>
 * <span style="color: rgb(255,240,245)">     LAVENDER_BLUSH             </span>
 * <span style="color: rgb(250,240,230)">     LINEN                      </span>
 * <span style="color: rgb(253,245,230)">     OLD_LACE                   </span>
 * <span style="color: rgb(255,239,213)">     PAPAYA_WHIP                </span>
 * <span style="color: rgb(255,245,238)">     SEA_SHELL                  </span>
 * <span style="color: rgb(245,255,250)">     MINT_CREAM                 </span>
 * <span style="color: rgb(112,128,144)">     SLATE_GRAY                 </span>
 * <span style="color: rgb(119,136,153)">     LIGHT_SLATE_GRAY           </span>
 * <span style="color: rgb(176,196,222)">     LIGHT_STEEL_BLUE           </span>
 * <span style="color: rgb(230,230,250)">     LAVENDER                   </span>
 * <span style="color: rgb(255,250,240)">     FLORAL_WHITE               </span>
 * <span style="color: rgb(240,248,255)">     ALICE_BLUE                 </span>
 * <span style="color: rgb(248,248,255)">     GHOST_WHITE                </span>
 * <span style="color: rgb(240,255,240)">     HONEYDEW                   </span>
 * <span style="color: rgb(255,255,240)">     IVORY                      </span>
 * <span style="color: rgb(240,255,255)">     AZURE                      </span>
 * <span style="color: rgb(255,250,250)">     SNOW                       </span>
 * <span style="color: rgb(0,0,0)">           BLACK                      </span>
 * <span style="color: rgb(105,105,105)">     DIM_GRAY                   </span>
 * <span style="color: rgb(128,128,128)">     GRAY                       </span>
 * <span style="color: rgb(169,169,169)">     DARK_GRAY                  </span>
 * <span style="color: rgb(192,192,192)">     SILVER                     </span>
 * <span style="color: rgb(211,211,211)">     LIGHT_GRAY                 </span>
 * <span style="color: rgb(220,220,220)">     GAINSBORO                  </span>
 * <span style="color: rgb(245,245,245)">     WHITE_SMOKE                </span>
 * <span style="color: rgb(255,255,255)">     WHITE                      </span>
 */
public enum ConsoleColor implements Color {

    MAROON(128, 0, 0),
    DARK_RED(139, 0, 0),
    BROWN(165, 42, 42),
    FIREBRICK(178, 34, 34),
    CRIMSON(220, 20, 60),
    RED(255, 0, 0),
    TOMATO(255, 99, 71),
    CORAL(255, 127, 80),
    INDIAN_RED(205, 92, 92),
    LIGHT_CORAL(240, 128, 128),
    DARK_SALMON(233, 150, 122),
    SALMON(250, 128, 114),
    LIGHT_SALMON(255, 160, 122),
    ORANGE_RED(255, 69, 0),
    DARK_ORANGE(255, 140, 0),
    ORANGE(255, 165, 0),
    GOLD(255, 215, 0),
    DARK_GOLDEN_ROD(184, 134, 11),
    GOLDEN_ROD(218, 165, 32),
    PALE_GOLDEN_ROD(238, 232, 170),
    DARK_KHAKI(189, 183, 107),
    KHAKI(240, 230, 140),
    OLIVE(128, 128, 0),
    YELLOW(255, 255, 0),
    YELLOW_GREEN(154, 205, 50),
    DARK_OLIVE_GREEN(85, 107, 47),
    OLIVE_DRAB(107, 142, 35),
    LAWN_GREEN(124, 252, 0),
    CHARTREUSE(127, 255, 0),
    GREEN_YELLOW(173, 255, 47),
    DARK_GREEN(0, 100, 0),
    GREEN(0, 128, 0),
    FOREST_GREEN(34, 139, 34),
    LIME(0, 255, 0),
    LIME_GREEN(50, 205, 50),
    LIGHT_GREEN(144, 238, 144),
    PALE_GREEN(152, 251, 152),
    DARK_SEA_GREEN(143, 188, 143),
    MEDIUM_SPRING_GREEN(0, 250, 154),
    SPRING_GREEN(0, 255, 127),
    SEA_GREEN(46, 139, 87),
    MEDIUM_AQUA_MARINE(102, 205, 170),
    MEDIUM_SEA_GREEN(60, 179, 113),
    LIGHT_SEA_GREEN(32, 178, 170),
    DARK_SLATE_GRAY(47, 79, 79),
    TEAL(0, 128, 128),
    DARK_CYAN(0, 139, 139),
    AQUA(0, 255, 255),
    CYAN(0, 255, 255),
    LIGHT_CYAN(224, 255, 255),
    DARK_TURQUOISE(0, 206, 209),
    TURQUOISE(64, 224, 208),
    MEDIUM_TURQUOISE(72, 209, 204),
    PALE_TURQUOISE(175, 238, 238),
    AQUA_MARINE(127, 255, 212),
    POWDER_BLUE(176, 224, 230),
    CADET_BLUE(95, 158, 160),
    STEEL_BLUE(70, 130, 180),
    CORN_FLOWER_BLUE(100, 149, 237),
    DEEP_SKY_BLUE(0, 191, 255),
    DODGER_BLUE(30, 144, 255),
    LIGHT_BLUE(173, 216, 230),
    SKY_BLUE(135, 206, 235),
    LIGHT_SKY_BLUE(135, 206, 250),
    MIDNIGHT_BLUE(25, 25, 112),
    NAVY(0, 0, 128),
    DARK_BLUE(0, 0, 139),
    MEDIUM_BLUE(0, 0, 205),
    BLUE(0, 0, 255),
    ROYAL_BLUE(65, 105, 225),
    BLUE_VIOLET(138, 43, 226),
    INDIGO(75, 0, 130),
    DARK_SLATE_BLUE(72, 61, 139),
    SLATE_BLUE(106, 90, 205),
    MEDIUM_SLATE_BLUE(123, 104, 238),
    MEDIUM_PURPLE(147, 112, 219),
    DARK_MAGENTA(139, 0, 139),
    DARK_VIOLET(148, 0, 211),
    DARK_ORCHID(153, 50, 204),
    MEDIUM_ORCHID(186, 85, 211),
    PURPLE(128, 0, 128),
    THISTLE(216, 191, 216),
    PLUM(221, 160, 221),
    VIOLET(238, 130, 238),
    MAGENTA(255, 0, 255),
    ORCHID(218, 112, 214),
    MEDIUM_VIOLET_RED(199, 21, 133),
    PALE_VIOLET_RED(219, 112, 147),
    DEEP_PINK(255, 20, 147),
    HOT_PINK(255, 105, 180),
    LIGHT_PINK(255, 182, 193),
    PINK(255, 192, 203),
    ANTIQUE_WHITE(250, 235, 215),
    BEIGE(245, 245, 220),
    BISQUE(255, 228, 196),
    BLANCHED_ALMOND(255, 235, 205),
    WHEAT(245, 222, 179),
    CORN_SILK(255, 248, 220),
    LEMON_CHIFFON(255, 250, 205),
    LIGHT_GOLDEN_ROD_YELLOW(250, 250, 210),
    LIGHT_YELLOW(255, 255, 224),
    SADDLE_BROWN(139, 69, 19),
    SIENNA(160, 82, 45),
    CHOCOLATE(210, 105, 30),
    PERU(205, 133, 63),
    SANDY_BROWN(244, 164, 96),
    BURLY_WOOD(222, 184, 135),
    TAN(210, 180, 140),
    ROSY_BROWN(188, 143, 143),
    MOCCASIN(255, 228, 181),
    NAVAJO_WHITE(255, 222, 173),
    PEACH_PUFF(255, 218, 185),
    MISTY_ROSE(255, 228, 225),
    LAVENDER_BLUSH(255, 240, 245),
    LINEN(250, 240, 230),
    OLD_LACE(253, 245, 230),
    PAPAYA_WHIP(255, 239, 213),
    SEA_SHELL(255, 245, 238),
    MINT_CREAM(245, 255, 250),
    SLATE_GRAY(112, 128, 144),
    LIGHT_SLATE_GRAY(119, 136, 153),
    LIGHT_STEEL_BLUE(176, 196, 222),
    LAVENDER(230, 230, 250),
    FLORAL_WHITE(255, 250, 240),
    ALICE_BLUE(240, 248, 255),
    GHOST_WHITE(248, 248, 255),
    HONEYDEW(240, 255, 240),
    IVORY(255, 255, 240),
    AZURE(240, 255, 255),
    SNOW(255, 250, 250),
    BLACK(0, 0, 0),
    DIM_GRAY(105, 105, 105),
    GRAY(128, 128, 128),
    DARK_GRAY(169, 169, 169),
    SILVER(192, 192, 192),
    LIGHT_GRAY(211, 211, 211),
    GAINSBORO(220, 220, 220),
    WHITE_SMOKE(245, 245, 245),
    WHITE(255, 255, 255);

    public static Color RGB(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException("Values must be in range: [0,255]");
        }
        return new ANSIColor(r, g, b);
    }

    public static Color HEX(String hex) {
        try {
            java.awt.Color decode = java.awt.Color.decode(hex);
            return new ANSIColor(decode.getRed(), decode.getGreen(), decode.getBlue());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Value must be between '#000000' and '#FFFFFF'");
        }
    }

    @Override
    public String colorize(String message) {
        return this.color.colorize(message);
    }

    @Override
    public String toString() {
        return name();
    }

    public static Color findColor(String color) {
        try {
            String enumName = color.toUpperCase().replaceAll(" ", "_");
            return ConsoleColor.valueOf(enumName);
        } catch (Exception e) {
            return NO_COLOR;
        }
    }

    private final Color color;

    ConsoleColor(int r, int g, int b) {
        this.color = new ANSIColor(r, g, b);
    }

    private record ANSIColor(int r, int g, int b) implements Color {

        public static final String UNICODE_ESC_CHAR = "\u001b";
        private static final String ANSI_COLOR_TEMPLATE = UNICODE_ESC_CHAR + "[38;2;%d;%d;%dm%s" + UNICODE_ESC_CHAR + "[0m";

        @Override
        public String colorize(String message) {
            return ANSI_COLOR_TEMPLATE.formatted(r, g, b, message);
        }

        @Override
        public String toString() {
            return "rgb(" + r +
                    "," + g +
                    "," + b +
                    ')';
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (ANSIColor) obj;
            return this.r == that.r &&
                    this.g == that.g &&
                    this.b == that.b;
        }
    }

    private static final Color NO_COLOR = new Color() {
        @Override
        public String colorize(String message) {
            return message;
        }

        @Override
        public String toString() {
            return "";
        }
    };

}
