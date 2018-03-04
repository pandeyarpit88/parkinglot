package com.gojek.parkingsystem;

import com.gojek.parkingsystem.service.ParkingService;

public class Application {


    public static void main(String[] args) {
        int paramsCount = args.length;
        ParkingService service;
        boolean isParkingLotCreated = false;

        if(paramsCount > 0) {
            String command = args[0];
            switch (command) {
                case "create_parking_lot":
                    service = new ParkingService();
                    break;
                case "park":

                    break;
                case "leave":

                    break;
                case "status":

                    break;
                case "registration_numbers_for_cars_with_colour":

                    break;
                case "slot_numbers_for_cars_with_colour":

                    break;
                case "slot_number_for_registration_number":

                    break;
                case "exit":
                    System.exit(0);
            }
        }
    }
}