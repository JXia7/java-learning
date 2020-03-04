
public class VoterCell extends AbstractCell {

    public VoterCell(int r, int c, ConwayWorld w) {
        super(r, c, w);
    }

    public boolean willBeAliveInNextGeneration() {
        int count = 0;

        int row = getRow();
        int column = getColumn();

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (world.isAlive(row + dr, column + dc)) {
                    count++;
                }
            }
        }

        return count >= 5;
    }

    public AbstractCell cellForNextGeneration() {
        VoterCell next = new VoterCell(getRow(), getColumn(), world);

        next.setIsAlive(willBeAliveInNextGeneration());

        return next;
    }
}