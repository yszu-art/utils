package art.yszu.utils.consolecolor;

interface Color {
    /**
     * Colorize message by inserting it between ANSI escape codes
     * @param message input message
     * @return colorized message
     */
    String colorize(String message);

    /**
     * Forced overriding of Object.toString()
     * @return string representation of color
     */
    String toString();

}
