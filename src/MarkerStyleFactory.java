import java.util.HashMap;
import java.util.Map;

public class MarkerStyleFactory {
    private static final Map<String, MarkerStyle> styles = new HashMap<>();
    private static int uniqueStyleCount = 0;

    public static MarkerStyle getStyle(String iconType, String color, String labelStyle) {
        String key = iconType + "-" + color + "-" + labelStyle;
        if (!styles.containsKey(key)) {
            styles.put(key, new MarkerStyle(iconType, color, labelStyle));
            uniqueStyleCount++;
        }
        return styles.get(key);
    }

    public static int getUniqueStyleCount() {
        return uniqueStyleCount;
    }
}