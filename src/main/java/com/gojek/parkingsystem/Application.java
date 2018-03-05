package com.gojek.parkingsystem;

import com.gojek.parkingsystem.model.Vehicle;
import com.gojek.parkingsystem.service.ParkingService;
import com.gojek.parkingsystem.validation.ParkingValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Application {
    static Logger log = LogManager.getLogger(Application.class);

    ParkingService service;

    public void performOperation(String[] params, int paramsLen) {
        String command = params[0];
        String output = "";
        switch (command) {
            case "create_parking_lot":
                if (paramsLen == 2) {
                    service = new ParkingService();
                    output = service.createParking(Integer.parseInt(params[1]));
                } else {
                    log.error("Insufficient parameters passed" + params.toString());
                }
                break;
            case "park":
                if (paramsLen == 3 && ParkingValidator.validateRegistrationNumber(params[1])) {
                    output = service.parkVehicle(new Vehicle(params[1], params[2]));
                } else {
                    log.error("Insufficient parameters passed" + params.toString());
                }
                break;
            case "leave":
                if(paramsLen == 2) {
                    output = service.removeVehicle(Integer.parseInt(params[1]));
                } else {
                    log.error("Insufficient parameters passed {}" + params.toString());
                }
                break;
            case "status":

                break;
            case "registration_numbers_for_cars_with_colour":
                if(paramsLen == 2) {
                    output = service.getRegistrationNumberForColor(params[1]);
                } else {
                    log.error("Insufficient parameters passed {}" + params.toString());
                }
                break;
            case "slot_numbers_for_cars_with_colour":
                if(paramsLen == 2) {
                    output = service.getSlotNumberForColor(params[1]);
                } else {
                    log.error("Insufficient parameters passed {}" + params.toString());
                }
                break;
            case "slot_number_for_registration_number":
                if(paramsLen == 2) {
                    output = service.getSlotNumberForRegistration(params[1]);
                } else {
                    log.error("Insufficient parameters passed {}" + params.toString());
                }
                break;
            case "exit":
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        int paramsCount = args.length;

        boolean isParkingLotCreated = false;

        if(paramsCount > 0) {
            String command = args[0];

            }
        }
    }
}