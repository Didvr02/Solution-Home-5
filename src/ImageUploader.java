public interface ImageUploader {
    void uploadImage(String filename, Agent currentUser);
    void replaceImage(String oldFilename, String newFilename, Agent currentUser);
    void displayThumbnail();
    void displayFullImage();
}