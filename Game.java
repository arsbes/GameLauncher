import java.util.Random;

public class Game {
    public void startGame() {
        Player player = new Player("Игрок", 10, 10, 10, 10);
        Monster monster = new Monster("Монстр", 10, 10, 10, 10);

        while (player.getHealth() > 0 && monster.getHealth() > 0) {

            int n = new Random().nextInt(2) + 1;
            if (n % 2 == 0) {
                System.out.println("Атакует игрок!");
                player.Attack(monster);
            } else {
                System.out.println("Монстр атакует игрока!");
                monster.Attack(player);
            }
        }
    }
}
