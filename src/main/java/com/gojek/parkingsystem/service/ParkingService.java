package com.gojek.parkingsystem.service;

import com.gojek.parkingsystem.model.Parking;
import com.gojek.parkingsystem.model.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingService {
    boolean isParkingCreated = false;
    TreeSet<Integer> vacantSlots = new TreeSet<>();
    HashMap<Integer, Parking> bookedSlots = new HashMap<>();

    public String createParking(int count) {
        for (int i = 1; i <= count; i++) {
            vacantSlots.add(i);
        }
        isParkingCreated = true;
        return "Created a parking lot with " + count + " slots";
    }

    public TreeSet<Integer> getFreeParking() {
        return vacantSlots;
    }

    public String parkVehicle(Vehicle vehicle) {
        if(vacantSlots.size() != 0) {
            int slotId = vacantSlots.pollFirst();
            bookedSlots.put(slotId, new Parking(slotId, vehicle));
            return "Allocated slot number: " + slotId;
        }
        return "Sorry, parking lot is full";
    }

    public String removeVehicle(int slotId) {
        if(bookedSlots.containsKey(slotId)) {
            bookedSlots.remove(slotId);
            vacantSlots.add(slotId);
            return "Slot number " + slotId + " is free";
        } else {
            return "Incorrect Slot Id";
        }
    }

    public String getSlotNumberForRegistration(String registrationNumber) {
        for(Map.Entry<Integer, Parking> entry : bookedSlots.entrySet()) {
            if(entry.getValue().getVehicle().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return String.valueOf(entry.getValue().getSlotId());
            }
        }
        return "Not found";
    }

    public String getRegistrationNumberForColor(String color) {
        return bookedSlots.values().parallelStream()
                .filter(x -> color.equalsIgnoreCase(x.getVehicle().getColor()))
                .map(x->x.getVehicle().getRegistrationNumber())
                .collect(Collectors.joining(", "));
    }

    public String getSlotNumberForColor(String color) {
        return bookedSlots.values().parallelStream()
                .filter(x -> color.equalsIgnoreCase(x.getVehicle().getColor()))
                .map(x->String.valueOf(x.getSlotId()))
                .collect(Collectors.joining(", "));
    }
}
