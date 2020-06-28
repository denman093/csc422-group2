import java.util.Random;

//class for the Soldier Survivor

public class Soldier implements ISurvivor {
    private int health = 100;
    private int attack = 10;
    private static int nextId = 1;
    private int id;
    private IWeapon heldWeapon;

    public Soldier() { 
        id = nextId++;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

//  @Override
//  public void attack(ICharacter victim) {
//  	victim.setHealth(victim.getHealth() - attack);
//  }
  
    @Override
    public void attack(ICharacter victim) {
    	Random rand = new Random();
		int attackChance = rand.nextInt(100 + 1);

		if (attackChance <= heldWeapon.getAccuracy()) {
			//System.out.println("Survivor has great aim.");
			//System.out.println(heldWeapon);
			//System.out.println("Random: " + attackChance + " Weapon Accuracy: " + heldWeapon.getAccuracy());
			
			victim.setHealth(victim.getHealth() - attack);
			//System.out.println();
		}

		//else {
			//System.out.println("Survivor has horrible aim.");
			//System.out.println("Random: " + attackChance + " Weapon Accuracy: " + heldWeapon.getAccuracy());
			//System.out.println(heldWeapon);
			//System.out.println();
		//}
    }

    @Override
    public int getHealth() {
        return health;
    }


    public boolean isAlive() {
        return health > 0;
    }

    public int getId() { 
        return id; 
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Soldier" + " " +  id;
    }

	public void setWeapon(IWeapon w) {
		if(w != null) {
		heldWeapon = w;
		attack = (int) heldWeapon.getDamage();
		}
	}

	public IWeapon getWeapon() {
		return heldWeapon;
	}

	@Override
	public double getAttack() {
		return attack;
	}

	@Override
	public void setAttack(int attack) {
		attack = (int) heldWeapon.getDamage();
	}
}

