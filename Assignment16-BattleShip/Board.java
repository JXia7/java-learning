import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private int xLength;
    private int yLength;
    public ArrayList<Ship> fleet;
    private boolean[] isShipSank;

    private String[][] grid = new String[11][11];

    public Board() {
        this.xLength = 10;
        this.yLength = 10;
        this.fleet = new ArrayList<Ship>(5);
        this.isShipSank = new boolean[5];
        this.load5ships();
        this.initializeGrid();
    }

    public void initializeGrid() {
        for(int i = 0; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                this.grid[i][j] = "~";
            }
        }
        for (int i = 0; i < 10; i++) {
            this.grid[i][0] = String.valueOf(9-i);
            this.grid[10][i+1] = String.valueOf(i);
        }
        this.grid[10][0] = " ";
    }

    public String toString() {
        String[] tmp = new String[11];
        for (int i = 0; i < 11; i++) {
            tmp[i] = String.join(" ", this.grid[i]);
        }
        return String.join("\n", tmp);
    }

    public boolean generateOneShip2Board() {
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        Point origin = new Point(x, y);
        boolean isVertical = random.nextInt(2)%2 == 0;
        int shipLength = 2+random.nextInt(4);
        if (isVertical) {
            if (y+shipLength >= 10) return false;
        } else {
            if (x+shipLength >= 10) return false;
        }
        Ship newShip = new Ship(origin, isVertical, shipLength);
        for(Ship existingShip: this.fleet) {
            if(newShip.collidesWith(existingShip)) return false;
        }
        this.fleet.add(newShip);
        return true;
    }

    public void load5ships() {
        int count = 0;
        while (count < 5) {
            if (this.generateOneShip2Board()) {
                count += 1;
            }
        }
    }

    public void userShot() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a coordinate: ");
        int x = input.nextInt();
        int y = input.nextInt();
        Point userShotPoint = new Point(x, y);
        for(int i = 0; i < 5; i++) {
            if (this.fleet.get(i).isSank()) continue;
            if (this.fleet.get(i).isHitAtPoint(userShotPoint)) {
                this.grid[9-y][1+x] = "X";
                System.out.println("Hit!");
                if (this.fleet.get(i).isSank()) {
                    this.isShipSank[i] = true;
                    System.out.println(String.format("You sank ship with length %d", this.fleet.get(i).getShipLength()));
                }
                return;
            }
        }
        this.grid[9-y][1+x] = ".";
        System.out.println("Miss.");
    }

    // check game over
    public boolean isAllShipSank() {
        for (boolean b: this.isShipSank) {
            if (!b) return false;
        }
        System.out.println("Game Over!");
        return true;
    }
}
