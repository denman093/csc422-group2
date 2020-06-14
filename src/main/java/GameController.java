import java.util.*;

public class GameController {
	//does all the fighting between Survivors and zombies
	public static void fightRound(ArrayList<ICharacter> attackers, ArrayList<ICharacter> defenders) {

		for(int i = 0; i < attackers.size(); i++) {
			for(int j = 0; j < defenders.size(); j++) {

				attackers.get(i).attack(defenders.get(j));

				if(!defenders.get(j).isAlive()) 
					defenders.remove(j);

				if(defenders.isEmpty())
					break;
			}
		}
	}

	public static void main(String[] args) {
		//Spawns the Survivors and Zombies for the game
		ArrayList<ICharacter> survivors = Spawner.spawnRandomSurvivors();
		ArrayList<ICharacter> zombies = Spawner.spawnRandomZombies();

		int numOfTank=0;
		int numOfCommon=0;
		int numOfChild=0;
		int numOfTeacher=0;
		int numOfSoldier=0;

		//gather numbers of each type of survivors
		for (ICharacter z : survivors) {
			if(z instanceof Soldier ){
				numOfSoldier += 1;
			} else if(z instanceof Teacher ) {
				numOfTeacher +=1;
			} else if (z instanceof Child ) {
				numOfChild +=1;
			}
		}

		//gather numbers of each type of zombie
		for (ICharacter z : zombies) {
			if (z instanceof ZombieTank) {
				numOfTank += 1;
			} else if (z instanceof ZombieCommon) {
				numOfCommon +=1;
			}	
		}

		System.out.println("We have " + survivors.size() + " survivors trying to make it to safety: ( " + numOfChild + " children, " + numOfTeacher + " teachers, " + numOfSoldier + " soldiers )"  );                     
		System.out.println("But there are " + zombies.size() + " zombies waiting for them. ( " + numOfCommon + " common infected, " + numOfTank + " tanks )" );


		//keep fighting back and forth til either Survivors or Zombies are dead
		while(survivors.size() > 0 && zombies.size() > 0) {
			fightRound(survivors, zombies);

			if(zombies.isEmpty()) 
				break;

			fightRound(zombies, survivors);

			if(survivors.isEmpty()) 
				break;
		}

		if(survivors.size() > 0)
			System.out.println("It seems " + survivors.size() + " have made it to safety.");
		else
			System.out.println("There are no survivors.");
	}
}
