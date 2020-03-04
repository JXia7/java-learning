
public class BlinkerCell extends AbstractCell{

    public BlinkerCell(int r, int c, ConwayWorld w) {
        super(r, c, w);
    }

    public boolean willBeAliveInNextGeneration() {
        if (getIsAlive()) {
            return false;
        }
        return true;
    }

    public AbstractCell cellForNextGeneration() {
        BlinkerCell next = new BlinkerCell(getRow(), getColumn(), world);

        next.setIsAlive(willBeAliveInNextGeneration());

        return next;
    }
}
