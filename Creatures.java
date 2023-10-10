import java.util.Random;

public class Creatures {
    private String name;
    private int attack;
    private int defense;
    protected int health;
    private int damage;

    public Creatures() {
    }

    public Creatures(String name, int attack, int defense, int damage, int health) {
        this.name = name;
        if (attack > 0 & defense > 0 & health > 0 & damage > 0) {
            this.attack = attack;
            this.defense = defense;
            this.health = health;
            this.damage = damage;
        } else {
            throw new IllegalArgumentException("Каждое значение должно быть положительным");
        }
    }

    public Creatures(String name, int attack, int defense, int damage) {
        this.name = name;
        if (attack > 0 & defense > 0 & damage > 0) {
            this.attack = attack;
            this.defense = defense;
            this.damage = damage;
        } else {
            throw new IllegalArgumentException("Каждое значение должно быть положительным");
        }
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void Attack(Creatures creatures) {
        int modAttack = getAttack() - creatures.getDefense() + 1;
        int dice = Math.max(modAttack, 1); // определяем количество кубиков
        boolean success = false; // успех атаки

        for (int i = 0; i < dice; i++) {
            int value = new Random().nextInt(6) + 1;

            if (value == 5 || value == 6) {
                success = true;
                break;
            } else {
                System.out.println("На кубике значение меньше 5. Атака не удалась!");
            }
        }
        if (success) {
            if (creatures instanceof Player) {  // если переданный в метод параметр является объектом класса Player, то лечим его
                ((Player) creatures).healing();
            }
            creatures.setHealth(creatures.getHealth() - (new Random().nextInt(getDamage()) + 1));
            if (creatures.getHealth() <= 0) {
                creatures.setHealth(0);
                System.out.println(creatures.getName() + " погиб! Бой завершён!");
            } else {
                System.out.println("Атака завершена! Здоровье персонажа " + creatures.getName() + " - " + creatures.getHealth());
            }
        }
    }
}

