import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

//class that generates the Survivors and Zombies 
public class Spawner {

	
	
	// max number of survivors or zombies
	public static final int MAX_CAPACITY = 20;

	// returns an ArrayList that will hold all Zombie types
	public static ArrayList<ICharacter> spawnRandomZombies() {

		ArrayList<ICharacter> zombies = new ArrayList<>(MAX_CAPACITY);
		Random rand = new Random();
		int totalZombies = 5 + rand.nextInt(15 + 1);

		// For as many zombies as there are, spawn a zombie
		for (int i = 0; i < totalZombies; i++) {

			int randomZombie = rand.nextInt(2);

			switch (randomZombie) {
			// if randomly chosen to be 0, create common
			case 0:
				zombies.add(new ZombieCommon());
				break;

			// if randomly chosen to be 1, create tank
			case 1:
				zombies.add(new ZombieTank());
				break;
			}
		}

		// return ArrayList of IZombies
		return zombies;
	}

	// returns an ArrayList that will hold all Survivor types
	public static ArrayList<ICharacter> spawnRandomSurvivors() {
		ArrayList<ICharacter> survivors = new ArrayList<>(MAX_CAPACITY);

		Random rand = new Random();
		int totalHumans = 5 + rand.nextInt(15 + 1);

		// spawn random survivor classes (soldier,teacher,child)
		for (int i = 0; i < totalHumans; i++) {

			int randomHuman = rand.nextInt(3);

			// get a random number thats between 0 and the max number of weapons in the cache
			int theirWeapon=2;
			
			switch (randomHuman) {
			// if randomly chosen to be 0, create soldier
			case 0:
				survivors.add(new Soldier(theirWeapon));
				break;

			// if randomly chosen to be 1, create teacher
			case 1:
				survivors.add(new Teacher(theirWeapon));
				break;

			// if randomly chosen to be 2, create child
			case 2:
				survivors.add(new Child(theirWeapon));
				break;
			}
		
		}

		// return ArrayList of survivors
		return survivors;
	}

	public static WeaponCache spawnWeaponCache() {
		return null;


	}
}