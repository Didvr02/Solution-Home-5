public class LocationMarker {
    private String name;
    private double latitude;
    private double longitude;
    private MarkerStyle style;

    public LocationMarker(String name, double latitude, double longitude, MarkerStyle style) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.style = style;
    }

    public void render() {
        style.render(latitude, longitude, name);
    }
}