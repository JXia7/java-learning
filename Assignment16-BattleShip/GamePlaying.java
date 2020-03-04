public class GamePlaying {

    public static void main(String[] args) {

        Board board = new Board();
//        for(Ship littleShip: board.fleet) {
//            System.out.println(littleShip);
//            System.out.println(littleShip.getPoints());
//        }
        while(!board.isAllShipSank()) {
            System.out.println(board.toString());
            board.userShot();
        }
    }
}
