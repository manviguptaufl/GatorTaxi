
public class MinHeap {
    private HeapNode[] heap;
    private int capacity;
    private int size;
    private static final int TOP = 1;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        initHeap(capacity);
    }

    private void initHeap(int capacity) {
        this.heap = new HeapNode[capacity + 1];
        this.heap[0] = null;
        size = 1;
    }

    public boolean isEmpty() {
        return size == 1;
    }

    private boolean hasParent(int position) {
        return position != 1;
    }

    private boolean isLeaf(int position) {
        return (position >= size / 2 && position <= size);
    }

    private int getParentPosition(int position) {
        return (position / 2);
    }

    private int getLeftChildPosition(int position) {
        return (position * 2);
    }

    private int getRightChildPosition(int position) {
        return (position * 2) + 1;
    }

    private void swap(int i, int j) {
        HeapNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(HeapNode node) {
        if (size > capacity) {
            throw new IllegalStateException("Error: Capacity Exceeded. Cannot insert more than " + capacity + " items.");
        }

        heap[size] = node;
        heapifyUp(size);
        size++;
    }

    private void heapifyUp(int position) {
        while (hasParent(position) && 
               (heap[position].getRideCost() <= heap[getParentPosition(position)].getRideCost() || 
                (heap[position].getRideCost() == heap[getParentPosition(position)].getRideCost() && 
                 heap[position].getTripDuration() < heap[getParentPosition(position)].getTripDuration()))) {
            swap(position, getParentPosition(position));
            position = getParentPosition(position);
        }
    }

    public HeapNode extractMin() {
        if (isEmpty()) {
            return null;
        }

        HeapNode item = heap[TOP];
        heap[TOP] = heap[size - 1];
        heapifyDown(TOP);
        heap[size - 1] = null;
        size--;
        return item;
    }

    private int find(int rideNumber) {
        for (int i = 1; i < size; i++) {
            if (heap[i].getRideNumber() == rideNumber)
                return i;
        }
        return -1;
    }

    public RedBlackNode delete(int rideNumber) {
        int index = find(rideNumber);
        if (index == -1)
            return null;
        RedBlackNode rbNode = heap[index].getRbtNodeReference();
        heap[index] = heap[size - 1];
        size--;
        heapifyDown(index);
        return rbNode;
    }

    private void heapifyDown(int position) {
        // Break the recursion when the item is leaf node.
        if(isLeaf(position)) return;

        // Left and Right child indexes.
        int left = getLeftChildPosition(position);
        int right = getRightChildPosition(position);

        // Check which child has smaller value. Tie is broken by comparing building number if executed time is same.
        boolean isLeftSmaller = (heap[left].getRideCost() != heap[right].getRideCost()) ? 
                                heap[left].getRideCost() < heap[right].getRideCost() : 
                                heap[left].getTripDuration() < heap[right].getTripDuration();

        if(isLeftSmaller && heap[position].getRideCost() >= heap[left].getRideCost() && 
           (heap[position].getRideCost() > heap[left].getRideCost() || 
           heap[position].getTripDuration() > heap[left].getTripDuration())) {
            swap(position, left);
            heapifyDown(left);
        } 
        else if(heap[position].getRideCost() >= heap[right].getRideCost() && 
                (heap[position].getRideCost() > heap[right].getRideCost() || 
                heap[position].getTripDuration() > heap[right].getTripDuration())) {
            swap(position, right);
            heapifyDown(right);
        }
    }
}