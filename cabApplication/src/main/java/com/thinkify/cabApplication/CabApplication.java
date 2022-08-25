package com.thinkify.cabApplication;

import com.thinkify.cabApplication.exceptions.InvalidInputException;
import com.thinkify.cabApplication.model.*;
import com.thinkify.cabApplication.service.DriverService;
import com.thinkify.cabApplication.service.RideService;
import com.thinkify.cabApplication.service.UserServive;
import com.thinkify.cabApplication.service.impl.DriverServiceImpl;
import com.thinkify.cabApplication.service.impl.RideServiceImpl;
import com.thinkify.cabApplication.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class CabApplication {

	private static final UserServive USER_SERVICE = new UserServiceImpl();

	private static final DriverService DRIVER_SERVICE = new DriverServiceImpl();

    private static final RideService RIDE_SERVICE = new RideServiceImpl();

    private static Map<String, Integer> availableRides = null;
    private static String selectedDriver = null;
    private static int price = -1;

	public static void main(String[] args) {
		SpringApplication.run(CabApplication.class, args);
		
		String filePath = "src/main/resources/command.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            for(String line; (line = br.readLine()) != null; ) {
                executeCommand(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	
	private static void executeCommand(String commandLine){
        if (commandLine== null || commandLine.isEmpty()){
            return;
        }
        String[] input = commandLine.split("\\(");
        String command = input[0].trim();
        String[] value;

        switch (command){
            case "add_user":
                String values= input[1].replace(')', ' ').trim();
                String[] val = values.split(",");
                if(val.length<3) {
                	throw new InvalidInputException(values);
                }
                User user = new User(val[0], Gender.valueOf(val[1].trim()), Integer.parseInt(val[2].trim()));
                USER_SERVICE.add_user(user);
                break;
            case "update_userLocation":
                String username = input[1].replace(',',' ').trim();
                String coordinate = input[2].replace('(',' ').replace(')',' ').trim();
                String[] ch = coordinate.split(",");
                Coordinate newCordCoordinate = new Coordinate(Integer.parseInt(ch[0]), Integer.parseInt(ch[1]));
                USER_SERVICE.update_userLocation(username, newCordCoordinate);
                break;
            case "add_driver":
                value = input[1].split(",");
                if (value.length<5){
                    throw new InvalidInputException(Arrays.toString(value));
                }
                Driver driver = new Driver(value[0].trim(), Gender.valueOf(value[1].trim()), Integer.parseInt(value[2].trim()));
                Vehicle vehicle = new Vehicle(value[3].trim(), value[4].trim());
                String[] ch1 = input[2].replace(')',' ').trim().split(",");
                Coordinate coordinate1 = new Coordinate(Integer.parseInt(ch1[0]), Integer.parseInt(ch1[1]));
                DRIVER_SERVICE.add_driver(driver, vehicle, coordinate1);
                break;
            case "find_ride":
                String userN = input[1].replace(',',' ').trim();
                String[] coord1 = input[2].replace(')',' ').trim().split(",");
                String[] coord2 = input[3].replace(')',' ').trim().split(",");
                Coordinate source = new Coordinate(Integer.parseInt(coord1[0].trim()), Integer.parseInt(coord1[1].trim()));
                Coordinate destination = new Coordinate(Integer.parseInt(coord2[0].trim()), Integer.parseInt(coord2[1].trim()));
                availableRides = RIDE_SERVICE.find_ride(userN, source, destination);
                //available drivers
                if (availableRides.isEmpty()){
                    System.out.println("No ride found");
                    break;
                }
                for (Map.Entry<String, Integer> entry : availableRides.entrySet()){
                    System.out.println(entry.getKey());
                }
                break;
            case "choose_ride":
                value = input[1].split(",");
                String usern = value[0].trim();
                selectedDriver = value[1].replace(')',' ').trim();
                if (availableRides == null || availableRides.isEmpty()){
                    System.out.println("No ride found");
                    break;
                }
                price = RIDE_SERVICE.choose_ride(usern, selectedDriver, availableRides);
                break;
            case "calculateBill":
                String usernam = input[1].replace(')', ' ').trim();
                if (price == -1 || selectedDriver == null){
                    System.out.println("driver not selected");
                   break;
                }
                RIDE_SERVICE.calculateBill(usernam, selectedDriver, price);
                System.out.println("ride Ended bill amount $"+price);
                availableRides.clear();
                selectedDriver = null;
                price = -1;
                break;
            case "change_driver_status":
                value = input[1].split(",");
                String driverName = value[0].trim();
                String status = value[1].replace(')',' ').trim();
                DRIVER_SERVICE.change_driver_status(driverName, Boolean.parseBoolean(status));
                break;
            case "find_total_earning":
                for (String s: DRIVER_SERVICE.find_total_earning()){
                    System.out.println(s);
                }
                break;
            default:
                System.out.println("Invalid Command");
                break;
        }
    }

}
