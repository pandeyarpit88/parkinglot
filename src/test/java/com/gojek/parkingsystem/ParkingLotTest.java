package com.gojek.parkingsystem;

import com.gojek.parkingsystem.model.Vehicle;
import com.gojek.parkingsystem.service.ParkingService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingService service;
    @Before
    public void setup() {
        service = new ParkingService();
        service.createParking(6);
    }

    @Test
    public void createParking() {
        String result = service.createParking(6);
        //Assert.assertTrue(result.equals("Parking Already Created!!!"));
    }

    @Test
    public void testAddVehicleToParking() {
        String str = service.parkVehicle(new Vehicle("KA-01-HH-1234", "White"));
        Assert.assertTrue(str.equals("Allocated slot number: 1"));
        str = service.parkVehicle(new Vehicle("KA-01-HH-9999", "White"));
        Assert.assertTrue(str.equals("Allocated slot number: 2"));
        str = service.parkVehicle(new Vehicle("KA-01-BB-0001", "Black"));
        Assert.assertTrue(str.equals("Allocated slot number: 3"));
        str = service.parkVehicle(new Vehicle("KA-01-HH-7777", "Red"));
        Assert.assertTrue(str.equals("Allocated slot number: 4"));
        str = service.parkVehicle(new Vehicle("KA-01-HH-2701", "Blue"));
        Assert.assertTrue(str.equals("Allocated slot number: 5"));
        str = service.parkVehicle(new Vehicle("KA-01-HH-3141", "Black"));
        Assert.assertTrue(str.equals("Allocated slot number: 6"));
        str = service.parkVehicle(new Vehicle("KA-01-HH-1234", "White"));
        Assert.assertTrue(str.equals("Sorry, parking lot is full"));
        str = service.removeVehicle(4);
        Assert.assertTrue(str.equals("Slot number 4 is free"));
        str = service.removeVehicle(4);
        Assert.assertTrue(str.equals("Incorrect Slot Id"));
        str = service.removeVehicle(6);
        Assert.assertTrue(str.equals("Slot number 6 is free"));
        str = service.parkVehicle(new Vehicle("KA-01-HH-3841", "Black"));
        Assert.assertTrue(str.equals("Allocated slot number: 4"));
        str = service.getRegistrationNumberForColor("White");
        Assert.assertTrue(str.equals("KA-01-HH-1234, KA-01-HH-9999"));
        str = service.getSlotNumberForRegistration("KA-01-HH-9999");
        Assert.assertTrue(str.equals("2"));
        str = service.getSlotNumberForColor("White");
        Assert.assertTrue(str.equals("1, 2"));
        str = service.getSlotNumberForRegistration("KA-01-HH-9990");
        Assert.assertTrue(str.equals("Not found"));
    }

    @After
    public void tearDown() {

    }
}
