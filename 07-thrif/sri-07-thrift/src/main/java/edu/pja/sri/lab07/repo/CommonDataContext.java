package edu.pja.sri.lab07.repo;

import edu.pja.sri.lab07.CarsList;
import edu.pja.sri.lab07.Customer;
import edu.pja.sri.lab07.CustomerList;
import edu.pja.sri.lab07.RentalCar;

import java.util.*;

public class CommonDataContext {

    public static Map<Integer, RentalCar> cars = new HashMap<>();
    public static Map<Integer, Customer> customers = new HashMap<>();

    public static CustomerList GetCustomers() {
        CustomerList customerList = new CustomerList();
        customerList.customers = new ArrayList<>(customers.values());
        return customerList;
    }

    public static CarsList GetCars() {
        CarsList cl = new CarsList();
        cl.cars = new ArrayList<>(cars.values());
        return cl;
    }

    public static Customer GetWhoIsRenting(int carId) {
        RentalCar car = cars.get(carId);
        for (Customer c:
             customers.values()) {
            if(c.rentedCurrently == car){
                return c;
            }
        }
        return null;
    }
}
