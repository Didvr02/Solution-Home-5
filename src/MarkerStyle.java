public class MarkerStyle {
    private String iconType;
    private String color;
    private String labelStyle;

    public MarkerStyle(String iconType, String color, String labelStyle) {
        this.iconType = iconType;
        this.color = color;
        this.labelStyle = labelStyle;
    }

    public String getIconType() {
        return iconType;
    }

    public String getColor() {
        return color;
    }

    public String getLabelStyle() {
        return labelStyle;
    }

    public void render(double latitude, double longitude, String label) {
        System.out.println("Rendering " + iconType + " marker at (" + latitude + ", " + longitude + ") with color " + color + " and label '" + label + "' (" + labelStyle + ")");
    }
}