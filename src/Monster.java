import java.util.Random;

public class Monster extends Thread {
    private boolean awake = false;
    private final int sleepDuration;

    public Monster(int sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

    public boolean isAwake() {
        return awake;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!isInterrupted()) {
            try {
                Thread.sleep(sleepDuration * 1000);
            } catch (InterruptedException e) {
                break;
            }
            awake = random.nextBoolean();
            if (awake) {
                System.out.println("Монстр пробуждается!");
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                break;
            }
            awake = false;
        }
    }
}
