package com.gojek.parkingsystem.model;

public class Parking {
    int slotId;
    Vehicle vehicle;

    public Parking(int slotId, Vehicle vehicle) {
        this.slotId = slotId;
        this.vehicle = vehicle;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
