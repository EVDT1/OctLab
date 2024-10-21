import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private int playerLives;

    public Game() {
        this.playerLives = 3;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (playerLives > 0) {
            System.out.println("Количество жизней: " + playerLives);
            System.out.println("Вы просыпаетесь в сыром, тёмном подвале. Что вы будете делать?");
            System.out.println("1 - Обыскать комод");
            System.out.println("2 - Осмотреть вещи");
            System.out.println("3 - Осмотреть подвал на наличие выхода");

            int choice = getPlayerChoice(scanner);

            switch (choice) {
                case 1:
                    searchDrawer();
                    break;
                case 2:
                    inspectItems();
                    break;
                case 3:
                    searchForExit();
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        System.out.println("Игра окончена!");
        scanner.close();
    }

    private int getPlayerChoice(Scanner scanner) {
        int choice = -1;
        while (true) {
            try {
                choice = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите число.");
                scanner.next();
            }
        }
        return choice;
    }

    private void searchDrawer() {
        System.out.println("Вы проверяете комод и находите старую карту. Она может помочь вам!");
        // Случай, когда игрок находит предмет
        if (Math.random() < 0.5) {
            System.out.println("Вы чувствуете себя более уверенно. Вы восстановили 1 жизнь!");
            playerLives++;
        } else {
            System.out.println("В комоде раздался скрип, и вы испугались! Вы теряете 1 жизнь.");
            playerLives--;
        }
    }

    private void inspectItems() {
        System.out.println("Вы осматриваете вещи и находите ржавый нож.");

        if (Math.random() < 0.3) {
            System.out.println("Вы чувствуете себя сильнее! Вы восстановили 1 жизнь!");
            playerLives++;
        } else {
            System.out.println("Вы случайно порезали палец. Вы теряете 1 жизнь.");
            playerLives--;
        }
    }

    private void searchForExit() {
        System.out.println("Вы осматриваете подвал и замечаете небольшой проход.");

        if (Math.random() < 0.2) {
            System.out.println("Вы нашли выход! Поздравляем, вы выиграли!");
            System.exit(0);
        } else {
            System.out.println("Это был тупик! Вы снова попали в ловушку и теряете 1 жизнь.");
            playerLives--;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
