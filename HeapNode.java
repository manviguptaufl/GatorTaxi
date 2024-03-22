

public class HeapNode extends Ride {
    // Pointer to the corresponding red black node.
    private RedBlackNode rbtNodeReference;

    // Constructor.
    public HeapNode(int rideNumber, int rideCost, int tripDuration, RedBlackNode rbtNodeReference) {
        super(rideNumber, rideCost, tripDuration);
        this.rbtNodeReference = rbtNodeReference;
    }

    public RedBlackNode getRbtNodeReference() {
        return rbtNodeReference;
    }

    public void setRbtNodeReference(RedBlackNode rbtNodeReference) {
        this.rbtNodeReference = rbtNodeReference;
    }
}
