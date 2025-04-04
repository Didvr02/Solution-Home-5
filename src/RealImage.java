// Реализация RealImage (Proxy Pattern)
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading high-resolution image: " + filename + "...");
        try {
            Thread.sleep(2000); // Simulate loading time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("High-resolution image: " + filename + " loaded.");
    }

    @Override
    public void displayThumbnail() {
        System.out.println("Displaying thumbnail of: " + filename);
    }

    @Override
    public void displayFullImage() {
        System.out.println("Displaying full image: " + filename);
    }
}