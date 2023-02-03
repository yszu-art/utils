# Console Color

Colorizes output of terminals supporting <a href="https://en.wikipedia.org/wiki/Color_depth#True_color_(24-bit)">True Color</a>
and uses <a href="https://en.wikipedia.org/wiki/ANSI_escape_code#24-bit">ANSI Escape sequence for 24-bit colors</a>
producing ```String``` with format like:

<code><span style="color: gray">{ESC}</span>[38;2;<span style="color: red">{r}</span>;<span style="color: green">{g}</span>;<span style="color: blue">{b}</span>m<span style="color: purple">{text}</span><span style="color: gray">{ESC}</span>[0m</code>

where:

* <span style="color: gray">{ESC}</span> - Unicode 1B <code></code>(the Escape character) 
* <span style="color: red">{r}</span> - red value 0-255
* <span style="color: green">{g}</span> - green value 0-255
* <span style="color: blue">{b}</span> - blue value 0-255
* <span style="color: purple">{text}</span> - text to colorize

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
        String colorized = color.colorize("HEX(#F03366): colorized message");
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
><span style="color: rgb(173,255,47)">rgb(173,255,47): colorized message</span>
> 
> <span style="color: rgb(240,51,102)">HEX: #F03366: colorized message</span>
> 
> <span style="color: rgb(255,105,180)">HOT_PINK: colorized message</span>
>
> <span style="color: rgb(0,191,255)">DEEP_SKY_BLUE: colorized message</span>
> 
> <span>not colorized message</span>

## Pre-defined colors:

ConsoleColor.*

> <span style="color: rgb(128,0,0)">         MAROON                     </span>
> <span style="color: rgb(139,0,0)">         DARK_RED                   </span>
> <span style="color: rgb(165,42,42)">       BROWN                      </span>
> <span style="color: rgb(178,34,34)">       FIREBRICK                  </span>
> <span style="color: rgb(220,20,60)">       CRIMSON                    </span>
> <span style="color: rgb(255,0,0)">         RED                        </span>
> <span style="color: rgb(255,99,71)">       TOMATO                     </span>
> <span style="color: rgb(255,127,80)">      CORAL                      </span>
> <span style="color: rgb(205,92,92)">       INDIAN_RED                 </span>
> <span style="color: rgb(240,128,128)">     LIGHT_CORAL                </span>
> <span style="color: rgb(233,150,122)">     DARK_SALMON                </span>
> <span style="color: rgb(250,128,114)">     SALMON                     </span>
> <span style="color: rgb(255,160,122)">     LIGHT_SALMON               </span>
> <span style="color: rgb(255,69,0)">        ORANGE_RED                 </span>
> <span style="color: rgb(255,140,0)">       DARK_ORANGE                </span>
> <span style="color: rgb(255,165,0)">       ORANGE                     </span>
> <span style="color: rgb(255,215,0)">       GOLD                       </span>
> <span style="color: rgb(184,134,11)">      DARK_GOLDEN_ROD            </span>
> <span style="color: rgb(218,165,32)">      GOLDEN_ROD                 </span>
> <span style="color: rgb(238,232,170)">     PALE_GOLDEN_ROD            </span>
> <span style="color: rgb(189,183,107)">     DARK_KHAKI                 </span>
> <span style="color: rgb(240,230,140)">     KHAKI                      </span>
> <span style="color: rgb(128,128,0)">       OLIVE                      </span>
> <span style="color: rgb(255,255,0)">       YELLOW                     </span>
> <span style="color: rgb(154,205,50)">      YELLOW_GREEN               </span>
> <span style="color: rgb(85,107,47)">       DARK_OLIVE_GREEN           </span>
> <span style="color: rgb(107,142,35)">      OLIVE_DRAB                 </span>
> <span style="color: rgb(124,252,0)">       LAWN_GREEN                 </span>
> <span style="color: rgb(127,255,0)">       CHARTREUSE                 </span>
> <span style="color: rgb(173,255,47)">      GREEN_YELLOW               </span>
> <span style="color: rgb(0,100,0)">         DARK_GREEN                 </span>
> <span style="color: rgb(0,128,0)">         GREEN                      </span>
> <span style="color: rgb(34,139,34)">       FOREST_GREEN               </span>
> <span style="color: rgb(0,255,0)">         LIME                       </span>
> <span style="color: rgb(50,205,50)">       LIME_GREEN                 </span>
> <span style="color: rgb(144,238,144)">     LIGHT_GREEN                </span>
> <span style="color: rgb(152,251,152)">     PALE_GREEN                 </span>
> <span style="color: rgb(143,188,143)">     DARK_SEA_GREEN             </span>
> <span style="color: rgb(0,250,154)">       MEDIUM_SPRING_GREEN        </span>
> <span style="color: rgb(0,255,127)">       SPRING_GREEN               </span>
> <span style="color: rgb(46,139,87)">       SEA_GREEN                  </span>
> <span style="color: rgb(102,205,170)">     MEDIUM_AQUA_MARINE         </span>
> <span style="color: rgb(60,179,113)">      MEDIUM_SEA_GREEN           </span>
> <span style="color: rgb(32,178,170)">      LIGHT_SEA_GREEN            </span>
> <span style="color: rgb(47,79,79)">        DARK_SLATE_GRAY            </span>
> <span style="color: rgb(0,128,128)">       TEAL                       </span>
> <span style="color: rgb(0,139,139)">       DARK_CYAN                  </span>
> <span style="color: rgb(0,255,255)">       AQUA                       </span>
> <span style="color: rgb(0,255,255)">       CYAN                       </span>
> <span style="color: rgb(224,255,255)">     LIGHT_CYAN                 </span>
> <span style="color: rgb(0,206,209)">       DARK_TURQUOISE             </span>
> <span style="color: rgb(64,224,208)">      TURQUOISE                  </span>
> <span style="color: rgb(72,209,204)">      MEDIUM_TURQUOISE           </span>
> <span style="color: rgb(175,238,238)">     PALE_TURQUOISE             </span>
> <span style="color: rgb(127,255,212)">     AQUA_MARINE                </span>
> <span style="color: rgb(176,224,230)">     POWDER_BLUE                </span>
> <span style="color: rgb(95,158,160)">      CADET_BLUE                 </span>
> <span style="color: rgb(70,130,180)">      STEEL_BLUE                 </span>
> <span style="color: rgb(100,149,237)">     CORN_FLOWER_BLUE           </span>
> <span style="color: rgb(0,191,255)">       DEEP_SKY_BLUE              </span>
> <span style="color: rgb(30,144,255)">      DODGER_BLUE                </span>
> <span style="color: rgb(173,216,230)">     LIGHT_BLUE                 </span>
> <span style="color: rgb(135,206,235)">     SKY_BLUE                   </span>
> <span style="color: rgb(135,206,250)">     LIGHT_SKY_BLUE             </span>
> <span style="color: rgb(25,25,112)">       MIDNIGHT_BLUE              </span>
> <span style="color: rgb(0,0,128)">         NAVY                       </span>
> <span style="color: rgb(0,0,139)">         DARK_BLUE                  </span>
> <span style="color: rgb(0,0,205)">         MEDIUM_BLUE                </span>
> <span style="color: rgb(0,0,255)">         BLUE                       </span>
> <span style="color: rgb(65,105,225)">      ROYAL_BLUE                 </span>
> <span style="color: rgb(138,43,226)">      BLUE_VIOLET                </span>
> <span style="color: rgb(75,0,130)">        INDIGO                     </span>
> <span style="color: rgb(72,61,139)">       DARK_SLATE_BLUE            </span>
> <span style="color: rgb(106,90,205)">      SLATE_BLUE                 </span>
> <span style="color: rgb(123,104,238)">     MEDIUM_SLATE_BLUE          </span>
> <span style="color: rgb(147,112,219)">     MEDIUM_PURPLE              </span>
> <span style="color: rgb(139,0,139)">       DARK_MAGENTA               </span>
> <span style="color: rgb(148,0,211)">       DARK_VIOLET                </span>
> <span style="color: rgb(153,50,204)">      DARK_ORCHID                </span>
> <span style="color: rgb(186,85,211)">      MEDIUM_ORCHID              </span>
> <span style="color: rgb(128,0,128)">       PURPLE                     </span>
> <span style="color: rgb(216,191,216)">     THISTLE                    </span>
> <span style="color: rgb(221,160,221)">     PLUM                       </span>
> <span style="color: rgb(238,130,238)">     VIOLET                     </span>
> <span style="color: rgb(255,0,255)">       MAGENTA                    </span>
> <span style="color: rgb(218,112,214)">     ORCHID                     </span>
> <span style="color: rgb(199,21,133)">      MEDIUM_VIOLET_RED          </span>
> <span style="color: rgb(219,112,147)">     PALE_VIOLET_RED            </span>
> <span style="color: rgb(255,20,147)">      DEEP_PINK                  </span>
> <span style="color: rgb(255,105,180)">     HOT_PINK                   </span>
> <span style="color: rgb(255,182,193)">     LIGHT_PINK                 </span>
> <span style="color: rgb(255,192,203)">     PINK                       </span>
> <span style="color: rgb(250,235,215)">     ANTIQUE_WHITE              </span>
> <span style="color: rgb(245,245,220)">     BEIGE                      </span>
> <span style="color: rgb(255,228,196)">     BISQUE                     </span>
> <span style="color: rgb(255,235,205)">     BLANCHED_ALMOND            </span>
> <span style="color: rgb(245,222,179)">     WHEAT                      </span>
> <span style="color: rgb(255,248,220)">     CORN_SILK                  </span>
> <span style="color: rgb(255,250,205)">     LEMON_CHIFFON              </span>
> <span style="color: rgb(250,250,210)">     LIGHT_GOLDEN_ROD_YELLOW    </span>
> <span style="color: rgb(255,255,224)">     LIGHT_YELLOW               </span>
> <span style="color: rgb(139,69,19)">       SADDLE_BROWN               </span>
> <span style="color: rgb(160,82,45)">       SIENNA                     </span>
> <span style="color: rgb(210,105,30)">      CHOCOLATE                  </span>
> <span style="color: rgb(205,133,63)">      PERU                       </span>
> <span style="color: rgb(244,164,96)">      SANDY_BROWN                </span>
> <span style="color: rgb(222,184,135)">     BURLY_WOOD                 </span>
> <span style="color: rgb(210,180,140)">      TAN                        </span>
> <span style="color: rgb(188,143,143)">     ROSY_BROWN                 </span>
> <span style="color: rgb(255,228,181)">     MOCCASIN                   </span>
> <span style="color: rgb(255,222,173)">     NAVAJO_WHITE               </span>
> <span style="color: rgb(255,218,185)">     PEACH_PUFF                 </span>
> <span style="color: rgb(255,228,225)">     MISTY_ROSE                 </span>
> <span style="color: rgb(255,240,245)">     LAVENDER_BLUSH             </span>
> <span style="color: rgb(250,240,230)">     LINEN                      </span>
> <span style="color: rgb(253,245,230)">     OLD_LACE                   </span>
> <span style="color: rgb(255,239,213)">     PAPAYA_WHIP                </span>
> <span style="color: rgb(255,245,238)">     SEA_SHELL                  </span>
> <span style="color: rgb(245,255,250)">     MINT_CREAM                 </span>
> <span style="color: rgb(112,128,144)">     SLATE_GRAY                 </span>
> <span style="color: rgb(119,136,153)">     LIGHT_SLATE_GRAY           </span>
> <span style="color: rgb(176,196,222)">     LIGHT_STEEL_BLUE           </span>
> <span style="color: rgb(230,230,250)">     LAVENDER                   </span>
> <span style="color: rgb(255,250,240)">     FLORAL_WHITE               </span>
> <span style="color: rgb(240,248,255)">     ALICE_BLUE                 </span>
> <span style="color: rgb(248,248,255)">     GHOST_WHITE                </span>
> <span style="color: rgb(240,255,240)">     HONEYDEW                   </span>
> <span style="color: rgb(255,255,240)">     IVORY                      </span>
> <span style="color: rgb(240,255,255)">     AZURE                      </span>
> <span style="color: rgb(255,250,250)">     SNOW                       </span>
> <span style="color: rgb(0,0,0)">           BLACK                      </span>
> <span style="color: rgb(105,105,105)">     DIM_GRAY                   </span>
> <span style="color: rgb(128,128,128)">     GRAY                       </span>
> <span style="color: rgb(169,169,169)">     DARK_GRAY                  </span>
> <span style="color: rgb(192,192,192)">     SILVER                     </span>
> <span style="color: rgb(211,211,211)">     LIGHT_GRAY                 </span>
> <span style="color: rgb(220,220,220)">     GAINSBORO                  </span>
> <span style="color: rgb(245,245,245)">     WHITE_SMOKE                </span>
> <span style="color: rgb(255,255,255)">     WHITE                      </span>