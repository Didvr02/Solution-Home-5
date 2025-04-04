public class ProxyPatternDemo {
    public static void main(String[] args) {
        ProxyImage image1 = new ProxyImage("property_image_1_lowres.jpg");
        ProxyImage image2 = new ProxyImage("property_image_2_lowres.png");

        System.out.println("Displaying thumbnails:");
        image1.displayThumbnail();
        image2.displayThumbnail();
        System.out.println("--------------------");

        System.out.println("Clicking to zoom on image 1:");
        image1.displayFullImage();
        System.out.println("--------------------");

        System.out.println("Clicking to zoom on image 2:");
        image2.displayFullImage();
        System.out.println("--------------------");

        // Bonus: Protection Proxy Example
        Agent agent1 = new Agent("john.doe", true);
        Agent visitor = new Agent("guest", false);

        ProtectedImageProxy protectedImage = new ProtectedImageProxy("luxury_villa.jpeg", agent1);

        System.out.println("\nTesting Protected Proxy:");
        protectedImage.displayThumbnail();
        protectedImage.displayFullImage(); // Anyone can view thumbnails and full images eventually

        protectedImage.uploadImage("new_villa.jpeg", agent1);
        protectedImage.uploadImage("unauthorized.gif", visitor);

        protectedImage.replaceImage("new_villa.jpeg", "new_villa_updated.jpeg", agent1);
        protectedImage.replaceImage("new_villa_updated.jpeg", "another_try.png", visitor);
    }
}