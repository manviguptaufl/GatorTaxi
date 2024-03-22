
// A generic class containing information regarding different types of test cases.
public class TestCase {
    // Contains enum value representing the type of operation to be performed.
    private TestCommand testCommand;

    // Unique integer identifier for the ride.
    private int rideNumber;
    // Total time required for trip.
    private int tripDuration;
    private int rideCost;

    // Range of ride numbers to be printed. 
    private int startRideNumber, endRideNumber;

    public TestCase() {}

    public TestCommand getTestCommand() {
        return testCommand;
    }

    public void setTestCommand(TestCommand testCommand) {
        this.testCommand = testCommand;
    }

    public int getrideCost() {
        return rideCost;
    }

    public void setrideCost(int rideCost) {
        this.rideCost = rideCost;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public void setRideNumber(int rideNumber) {
        this.rideNumber = rideNumber;
    }

    public int getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(int tripDuration) {
        this.tripDuration = tripDuration;
    }

    public int getStartRideNumber() {
        return startRideNumber;
    }

    public void setStartRideNumber(int startRideNumber) {
        this.startRideNumber = startRideNumber;
    }

    public int getEndRideNumber() {
        return endRideNumber;
    }

    public void setEndRideNumber(int endRideNumber) {
        this.endRideNumber = endRideNumber;
    }   
}