public class FlyweightPatternDemo {
    public static void main(String[] args) {
        // Определяем несколько общих стилей маркеров
        MarkerStyle hospitalStyle = MarkerStyleFactory.getStyle("hospital", "red", "bold");
        MarkerStyle restaurantStyle = MarkerStyleFactory.getStyle("restaurant", "green", "italic");
        MarkerStyle gasStationStyle = MarkerStyleFactory.getStyle("gas", "blue", "normal");

        int numMarkers = 1000;
        LocationMarker[] markers = new LocationMarker[numMarkers];

        System.out.println("Creating " + numMarkers + " markers...");
        for (int i = 0; i < numMarkers; i++) {
            if (i % 3 == 0) {
                markers[i] = new LocationMarker("City Hospital " + i, 37.77 + i * 0.001, -122.41 + i * 0.001, hospitalStyle);
            } else if (i % 3 == 1) {
                markers[i] = new LocationMarker("Delicious Diner " + i, 37.78 + i * 0.001, -122.42 + i * 0.001, restaurantStyle);
            } else {
                markers[i] = new LocationMarker("Quick Fuel " + i, 37.79 + i * 0.001, -122.43 + i * 0.001, gasStationStyle);
            }
        }
        System.out.println("Markers created.");

        System.out.println("\nRendering markers:");
        for (LocationMarker marker : markers) {
            marker.render();
        }

        System.out.println("\n--------------------");
        System.out.println("Total number of markers created: " + markers.length);
        System.out.println("Number of unique marker style objects created: " + MarkerStyleFactory.getUniqueStyleCount());

        // Измерение выигрыша в памяти (приблизительно - сильно зависит от JVM)
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        // Объекты уже созданы, поэтому выигрыш заключается в том, что не создается много дубликатов стилей.

        // Чтобы продемонстрировать потенциальную экономию памяти, рассмотрим, что произошло бы без Flyweight:
        long estimatedMemoryWithoutFlyweight = (long) numMarkers * (3 * 4 + 3 * 4 + 3 * 4); // Приблизительный размер ссылок на String (icon, color, label)
        long estimatedMemoryWithFlyweight = (long) numMarkers * (4) + (long) MarkerStyleFactory.getUniqueStyleCount() * (3 * 4 + 3 * 4 + 3 * 4); // Размер ссылки на стиль + уникальные стили

        System.out.println("\nApproximate memory usage (conceptual):");
        System.out.println("Estimated without Flyweight (per marker storing style data): Significantly higher");
        System.out.println("Estimated with Flyweight (sharing style objects): Lower due to shared styles");

        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("\nActual memory usage (after creating objects): " + (memoryAfter - memoryBefore) / (1024 * 1024) + " MB (This includes all objects)");
        System.out.println("The primary benefit of Flyweight here is the reduction in the number of `MarkerStyle` objects created.");
    }
}