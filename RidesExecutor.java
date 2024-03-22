import java.io.IOException;
import java.util.*;



public class RidesExecutor {
    private Queue<TestCase> testCases;
    private MinHeap minHeap;
    private RedBlackTree redBlackTree;
    private static final int MAX_RIDES = 2000;

    public RidesExecutor(Queue<TestCase> testCases) {
        this.testCases = testCases;
        this.minHeap = new MinHeap(MAX_RIDES);
        this.redBlackTree = new RedBlackTree();
    }

    public void build() {
        while (!testCases.isEmpty()) {
            TestCase testCase = testCases.peek();
            if (testCase.getTestCommand() == TestCommand.INSERT) {
                try {
                    insertBuilding(testCase.getRideNumber(), testCase.getrideCost(), testCase.getTripDuration());
                    // OutputParser.addBuilding(redBlackTree.search(testCase.getBuildingId()));
                } catch (Exception exception) {
                    OutputParser.addErrorMessage(exception.getMessage());
                    finish();
                }
            } else if (testCase.getTestCommand() == TestCommand.PRINT) {
                OutputParser.addRideTuple(redBlackTree.search(testCase.getStartRideNumber()));
            } else if (testCase.getTestCommand() == TestCommand.GETNEXTRIDE) {
                getNextNode();
            } else if (testCase.getTestCommand() == TestCommand.PRINTBTW) {
                OutputParser.addBetweenRides(redBlackTree.searchInRange(testCase.getStartRideNumber(),
                        testCase.getEndRideNumber()));
            } else if (testCase.getTestCommand() == TestCommand.CANCEL) {
                cancelRide(testCase.getRideNumber());
            } else if (testCase.getTestCommand() == TestCommand.UPDATE) {
                updateRide(testCase);
            }
            testCases.remove();
        }
        finish();
    }
    // Finish execution. Print the output to the file.
private void finish() {
    try {
        OutputParser.print();
        System.exit(0);
    } catch(IOException e) {
        e.printStackTrace();
    }
}

// Inserts new building to be worked in Min heap and Red black tree.
private void insertBuilding(int rideNumber, int rideCost, int tripDuration) {
    //checks if duplicate ride exists and then inserts
    RedBlackNode rbNode = new RedBlackNode(rideNumber, rideCost, tripDuration);
    RedBlackNode exist = redBlackTree.search(rideNumber);
    //OutputParser.addBuilding(exist);
    if(exist == null) {
        HeapNode heapNode = new HeapNode(rideNumber, rideCost, tripDuration, rbNode);
        rbNode.setHeapNodeReference(heapNode);
        redBlackTree.insert(rbNode);
        minHeap.insert(heapNode);
    } else {
        //OutputParser.appendString("Duplicate RideNumber");
        throw new IllegalArgumentException("Duplicate RideNumber");
    }
}

private void getNextNode(){
    //checks if next Node exists and then removes 
    HeapNode min = minHeap.extractMin();
    if(min != null){
        OutputParser.addRideTuple(min.getRbtNodeReference());
        redBlackTree.delete(min.getRbtNodeReference());
    } else{
        OutputParser.appendString("No active ride requests");
    }
} 

private void cancelRide(int rideNumber){
    //Checks if a ride exists and then deletes
    RedBlackNode exist = redBlackTree.search(rideNumber);
    if(exist != null){
        RedBlackNode node = minHeap.delete(rideNumber);
        //OutputParser.addBuilding(node);
        redBlackTree.delete(node);
    } else {
        return;
    }
}

private void updateRide(TestCase testcase){
    RedBlackNode node = redBlackTree.search(testcase.getRideNumber());
    if(testcase.getTripDuration() <= node.getTripDuration()){
        HeapNode heapnode = node.getHeapNodeReference();
        node.setTripDuration(testcase.getTripDuration());
        heapnode.setTripDuration(testcase.getTripDuration());
    }
    else if(node.getTripDuration() < testcase.getTripDuration() && testcase.getTripDuration() <= 2*node.getRideNumber()) {
        redBlackTree.delete(node);
        minHeap.delete(node.getRideNumber());
        insertBuilding(node.getRideNumber(), node.getRideCost() + 10, testcase.getTripDuration());
    }
    else if(testcase.getTripDuration() > 2*node.getTripDuration()){
        redBlackTree.delete(node);
        minHeap.delete(node.getRideNumber());
    }   
}
}
