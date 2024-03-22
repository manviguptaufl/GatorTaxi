
public class RedBlackNode extends Ride {
    // Null external black node.
    public static final RedBlackNode NIL = new RedBlackNode(-1, -1, -1);

    // Left, Right and Parent pointers.
    private RedBlackNode left;
    private RedBlackNode right;
    private RedBlackNode parent;

    // Color of the node. Red or Black.
    private NodeColor color;

    // Corresponding heap node reference.
    private HeapNode heapNodeReference;

    public RedBlackNode(int rideNumber, int rideCost, int tripDuration) {
        super(rideNumber, rideCost, tripDuration);
        this.left = NIL;
        this.right = NIL;
        this.parent = NIL;

        // Set RED color to all the nodes except NIL node, by default.
        this.color = rideNumber == -1 ? NodeColor.BLACK : NodeColor.RED;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public HeapNode getHeapNodeReference() {
        return heapNodeReference;
    }

    public void setHeapNodeReference(HeapNode heapNodeReference) {
        this.heapNodeReference = heapNodeReference;
    }

    public RedBlackNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode left) {
        this.left = left;
    }

    public RedBlackNode getRight() {
        return right;
    }

    public void setRight(RedBlackNode right) {
        this.right = right;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "(" + this.getRideNumber() + "," + this.getRideCost() + "," + this.getTripDuration() + ")";
    }
}
