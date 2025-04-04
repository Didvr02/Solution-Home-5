import java.util.Objects;

public class ProtectedImageProxy implements ImageUploader {
    private String filename;
    private RealImage realImage;
    private Agent uploader; // Агент, который изначально загрузил (для потенциальных проверок владения)

    public ProtectedImageProxy(String filename, Agent uploader) {
        this.filename = filename;
        this.uploader = uploader;
    }

    @Override
    public void displayThumbnail() {
        System.out.println("Displaying thumbnail proxy (protected) for: " + filename);
    }

    @Override
    public void displayFullImage() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.displayFullImage();
    }

    @Override
    public void uploadImage(String filename, Agent currentUser) {
        if (currentUser != null && currentUser.isLoggedIn()) {
            System.out.println("Agent " + currentUser.getUsername() + " is uploading: " + filename);
            // Симуляция загрузки
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.filename = filename;
            this.realImage = null; // Сброс, если новое изображение "загружено"
            this.uploader = currentUser;
            System.out.println(filename + " uploaded successfully.");
        } else {
            System.out.println("Permission denied: Only logged-in agents can upload images.");
        }
    }

    @Override
    public void replaceImage(String oldFilename, String newFilename, Agent currentUser) {
        if (currentUser != null && currentUser.isLoggedIn() && Objects.equals(this.filename, oldFilename)) {
            System.out.println("Agent " + currentUser.getUsername() + " is replacing " + oldFilename + " with " + newFilename);
            // Симуляция замены
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.filename = newFilename;
            this.realImage = null; // Принудительная перезагрузка при следующем запросе полной версии
            System.out.println("Image replaced with " + newFilename + ".");
        } else if (currentUser == null || !currentUser.isLoggedIn()) {
            System.out.println("Permission denied: Only logged-in agents can replace images.");
        } else {
            System.out.println("Error: Cannot replace. The current image is not " + oldFilename + ".");
        }
    }
}