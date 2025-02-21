import java.util.*;

public class BaseConversion {
    public static void main(String[] args) {
        // Defining the map for the provided data
        Map<String, Map<String, String>> data = new HashMap<>();

        // Populate the data based on the provided JSON structure
        Map<String, String> item1 = new HashMap<>();
        item1.put("base", "10");
        item1.put("value", "4");

        Map<String, String> item2 = new HashMap<>();
        item2.put("base", "2");
        item2.put("value", "111");

        Map<String, String> item3 = new HashMap<>();
        item3.put("base", "10");
        item3.put("value", "12");

        Map<String, String> item6 = new HashMap<>();
        item6.put("base", "4");
        item6.put("value", "213");

        // Add the individual items to the main data map
        data.put("1", item1);
        data.put("2", item2);
        data.put("3", item3);
        data.put("6", item6);

        // Iterate through the map and convert values
        for (Map.Entry<String, Map<String, String>> entry : data.entrySet()) {
            String key = entry.getKey();
            Map<String, String> baseValue = entry.getValue();

            String base = baseValue.get("base");
            String value = baseValue.get("value");

            try {
                // Convert the value to base 10
                int decimalValue = convertToBase10(value, Integer.parseInt(base));

                // Output the results
                System.out.println("Key: " + key + ", Base: " + base + ", Value: " + value + " => Base 10: " + decimalValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format for key: " + key);
            } catch (Exception e) {
                System.out.println("Error processing key: " + key + ", " + e.getMessage());
            }
        }
    }

    // Method to convert value from any base to decimal (base 10)
    public static int convertToBase10(String value, int base) {
        return Integer.parseInt(value, base);
    }
}
