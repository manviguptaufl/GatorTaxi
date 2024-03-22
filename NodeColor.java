

// Color options for the red black node.
public enum NodeColor {
    RED("Red"),
    BLACK("Black");

    private String colorName;

    private NodeColor(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}
