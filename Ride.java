
/**
 * A POJO class for ride details.
 * - rideNumber - unique integer identifier for each building
 * - rideCost - total number of days spent so far working on this building
 * - tripDuration - total number of days needed to complete the construction of the building
 */

 public class Ride {
    private int rideNumber;
    private int rideCost;
    private int tripDuration;

    public Ride(int rideNumber, int rideCost, int tripDuration) {
        this.rideNumber = rideNumber;
        this.rideCost = rideCost;
        this.tripDuration = tripDuration;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public void setRideNumber(int rideNumber) {
        this.rideNumber = rideNumber;
    }

    public int getRideCost() {
        return rideCost;
    }

    public void setRideCost(int rideCost) {
        this.rideCost = rideCost;
    }

    public int getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(int tripDuration) {
        this.tripDuration = tripDuration;
    }

    @Override
    public String toString() {
        return "(" + getRideNumber() + "," + getRideCost() + "," + getTripDuration() + ")";
    }
}
