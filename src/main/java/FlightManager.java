import java.util.ArrayList;
import java.util.Random;

public class FlightManager {
    private Flight flight;
    private int weightPerBag;
    private int totalWeight;
    private Random randomSeat;
    private int seat;
    private ArrayList<Integer> seatsTaken;
    private int totalSeats;


    public FlightManager(Flight flight) {
        this.flight = flight;
        this.weightPerBag = 10;
        this.totalWeight = 0;
        this.randomSeat = new Random();
        this.seat = seat;
        this.seatsTaken = new ArrayList<Integer>();
        this.totalSeats = flight.getPlane().getPlaneType().getCapacity();
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

    public int getRemainingWeightAllowance() {
        return flight.getPlane().getPlaneType().getTotalWeight() - getTotalBaggaeWeight();
    }
    public int isSeatTaken (Integer seat) {
        if(seatsTaken.contains(seat)){
            int newSeat = randomSeat.nextInt(totalSeats) + 1;
            return isSeatTaken(newSeat);

        } else {
            return seat;
        }

    }

//    public void addPassenger(Passenger passenger) {
//        flight.addPassenger(passenger);
//        int availableSeats = flight.getAvailableSeats();
//        int seat = randomSeat.nextInt(availableSeats) + 1;
//        passenger.setSeatNumber(seat);
//    }

    public void addPassenger(Passenger passenger) {
        if (flight.getAvailableSeats() > 0) {

            int tempSeat = randomSeat.nextInt(totalSeats) + 1;
            seat = isSeatTaken(tempSeat);
            seatsTaken.add(seat);
            flight.addPassenger(passenger);
            passenger.setSeatNumber(seat);
        }
    }
}
