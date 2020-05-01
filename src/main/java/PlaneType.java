public enum PlaneType {
    ERCOUPE(1, 20),
    ECLIPSE(6, 100),
    CESSNA(4, 50),
    PILATUS(12, 130);


    private final int capacity, totalWeight;

    PlaneType(int capacity, int totalWeight) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}


