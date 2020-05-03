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
    private ArrayList<Passenger> arr;


    public FlightManager(Flight flight) {
        this.flight = flight;
        this.weightPerBag = 10;
        this.totalWeight = 0;
        this.randomSeat = new Random();
        this.seat = seat;
        this.seatsTaken = new ArrayList<Integer>();
        this.totalSeats = flight.getPlane().getPlaneType().getCapacity();
        this.arr = new ArrayList<Passenger>();
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

    public void addPassenger(Passenger passenger) {
        if (flight.getAvailableSeats() > 0) {

            int tempSeat = randomSeat.nextInt(totalSeats) + 1;
            seat = isSeatTaken(tempSeat);
            seatsTaken.add(seat);
            flight.addPassenger(passenger);
            passenger.setSeatNumber(seat);
        }
    }

    public void sortBySeatNumber() {
        arr = flight.getPassengers();
        int n = arr.size();

        for(int i=0; i < n - 1; i++){
            for (int j = 0; j < n-i-1; j++)
                if (arr.get(j).getSeatNumber() > arr.get(j+1).getSeatNumber())
                {
                    // swap arr[j+1] and arr[i]
                    Passenger temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }

            }
        }

        public Passenger findPassengerBySeatNumber(int seatNumber) {
            sortBySeatNumber();
            int high = arr.size();
            int low = 1;
            Passenger foundPassenger = null;
            while(low <= high){
                int mid = (low + high) /2;
                if (arr.get(mid).getSeatNumber() < seatNumber){
                    low = mid + 1;
                } else if (arr.get(mid).getSeatNumber() > seatNumber){
                    high = mid -1;
                } else if (arr.get(mid).getSeatNumber() == seatNumber){
                    foundPassenger = arr.get(mid);
                    break;
                }
            }
            return foundPassenger;
        }

    }
