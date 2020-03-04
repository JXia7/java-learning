import java.util.*;

public class ConwayMain {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		ConwayWorld world = new ConwayWorld();

		chooseGameToPlay(world);

		// Add an always-alive cells
		AbstractCell a = new AlwaysAliveCell(12, 12, world);
		world.replaceCell(a);

		// Add an always-alive cells
		AbstractCell n = new NeverAliveCell(17, 17, world);
		world.replaceCell(n);

		do {

			world.display();
			world.advanceToNextGeneration();

			System.out.print("Another? (y/n): ");
		} while (input.nextLine().charAt(0) == 'y');
	}

	public static void chooseGameToPlay(ConwayWorld world) {
		System.out.println("------------------------Game Beginning------------------------");
		System.out.println("Input 1 for BlinkerCell game.");
		System.out.println("Input 2 for VoterCell game.");
		System.out.print("Which game do you want to Play? ");

		if (input.nextLine().charAt(0) == '1') {
			System.out.println();
			System.out.println("Welcome to BlinkerCell game.");
			playBlinkerCell(world);
		} else {
			System.out.println();
			System.out.println("Welcome to VoterCell game.");
			playTogetherCell(world);
		}

	}

	public static void playBlinkerCell(ConwayWorld world) {
		// Play BlinkerCell
		world.BlinkerWorld();

		// Add some live Blinker cells
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 ; j++) {
				BlinkerCell bCell = new BlinkerCell(5 + i, 5 + j, world);
				bCell.setIsAlive(true);
				world.replaceCell(bCell);
			}
		}
	}

	public static void playTogetherCell(ConwayWorld world) {
		//Play VoterCell
		world.VoterWorld();

		// Add some live Together cells
		Random randomCell = new Random();
		for (int i = 0; i < 200; i++) {
			VoterCell vCell = new VoterCell(randomCell.nextInt(20), randomCell.nextInt(20), world);
			vCell.setIsAlive(true);
			world.replaceCell(vCell);
		}

	}
}