import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class GameConfig {
    private HashMap<String, String> config = new HashMap<>();

    public GameConfig(String filePath) throws IOException {
        loadConfig(filePath);
        validateConfig();
    }

    private void loadConfig(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    config.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
    }

    private void validateConfig() {

        String roomsValue = config.get("rooms");
        if (roomsValue == null || !isInteger(roomsValue) || !isInRange(Integer.parseInt(roomsValue), 10, 30)) {
            config.put("rooms", "10");
        }

        String monsterSleepValue = config.get("monsterSleepDuration");
        if (monsterSleepValue == null || !isInteger(monsterSleepValue) || !isInRange(Integer.parseInt(monsterSleepValue), 30, 60)) {
            config.put("monsterSleepDuration", "60");
        }

        String playerLivesValue = config.get("playerLives");
        if (playerLivesValue == null || !isInteger(playerLivesValue) || !isInRange(Integer.parseInt(playerLivesValue), 1, 3)) {
            config.put("playerLives", "3");
        }
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public int getRoomsCount() {
        return Integer.parseInt(config.get("rooms"));
    }

    public int getMonsterSleepDuration() {
        return Integer.parseInt(config.get("monsterSleepDuration"));
    }

    public int getPlayerLives() {
        return Integer.parseInt(config.get("playerLives"));
    }
}
