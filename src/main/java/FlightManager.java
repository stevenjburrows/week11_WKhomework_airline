public class FlightManager {
    private Flight flight;
    private int weightPerBag;
    private int totalWeight;

    public FlightManager(Flight flight) {
        this.flight = flight;
        this.weightPerBag = 10;
        this.totalWeight = 0;
    }

    public Flight getFlight() {
        return flight;
    }


    public int getBaggageforEachPassenger(Passenger passenger) {
        return passenger.getNoOfBags() * weightPerBag;
    }

    public int getTotalBaggaeWeight() {
        for ( Passenger passengers : flight.getPassengers()){
            totalWeight += getBaggageforEachPassenger(passengers);
        }
        return totalWeight;
    }

    public int getremainingWeightAllowance() {
        return flight.getPlane().getPlaneType().getTotalWeight() - getTotalBaggaeWeight();
    }
}
