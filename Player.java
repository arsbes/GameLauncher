import java.util.Random;

public class Player extends Creatures {
    private int count = 4; // количество попыток исцеления

    public Player(String name, int attack, int defense, int damage, int health) {
        super(name, attack, defense, damage);
        this.health = health;
    }

    public int maxHealth() {
        return health;
    }

    public void healing() {
        if (count > 0) {
            setHealth(getHealth() + (int) (maxHealth() * 0.3));
            if (getHealth() > maxHealth()) {
                setHealth(maxHealth());
            }
            System.out.println("Здоровье поправлено! Теперь у игрока " + getHealth() + " здоровья");
            count--;
        } else {
            System.out.println("Не осталось попыток исцеления!");
        }

    }


}
