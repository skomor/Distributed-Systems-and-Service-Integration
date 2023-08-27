package edu.pja.sri.lab07.server.handlers;

import edu.pja.sri.lab07.*;
import edu.pja.sri.lab07.repo.CommonDataContext;
import org.apache.thrift.TException;

import java.util.ArrayList;

public class RentalCompanyHandler implements RentalCompanyService.Iface {
    @Override
    public CarsList getAllCars() throws TException {
        return CommonDataContext.GetCars();
    }

    @Override
    public int addNewCustomer(Customer customer) throws TException {
        customer.rentedCarsInPast = new CarsList().setCars(new ArrayList<>());
        int id = customer.hashCode();

        CommonDataContext.customers.put(id, customer);
        return id;
    }

    @Override
    public void removeCustomer(int customerId) throws NotExistsEx, TException {
        if(!CommonDataContext.customers.containsKey(customerId)){
            throw new NotExistsEx();
        }
        CommonDataContext.cars.remove(customerId);
    }

    @Override
    public void rentCar(int carId, int customerId) throws AlreadyRentedEx, AlreadyRentingEx, NoIndexFoundEx, TException {
        if(!CommonDataContext.customers.containsKey(customerId)){
            throw new NoIndexFoundEx("customerId");
        }
        if(!CommonDataContext.cars.containsKey(carId)){
            throw new NoIndexFoundEx("carId");
        }
        if(CommonDataContext.cars.get(carId).isRented){
            throw new AlreadyRentedEx();
        }
        if(CommonDataContext.customers.get(customerId).isRenting){
            throw new AlreadyRentingEx();
        }
        CommonDataContext.customers.get(customerId).isRenting = true;
        CommonDataContext.customers.get(customerId).rentedCurrently = CommonDataContext.cars.get(carId);
        CommonDataContext.cars.get(carId).isRented = true;
        CommonDataContext.customers.get(customerId).rentedCarsInPast.cars.add(CommonDataContext.cars.get(carId));
    }

    @Override
    public CarsList getRentedCarsBy(int customerId) throws NoIndexFoundEx, TException {
        return   CommonDataContext.customers.get(customerId).rentedCarsInPast;
    }

    @Override
    public void unrentCar(int carId, int customerId) throws NotRentingEx, NoIndexFoundEx, TException {
        if(!CommonDataContext.customers.containsKey(customerId)){
            throw new NoIndexFoundEx("customerId");
        }
        if(!CommonDataContext.cars.containsKey(carId)){
            throw new NoIndexFoundEx("carId");
        }
        if(!CommonDataContext.cars.get(carId).isRented){
            throw new NotRentingEx();
        }
        if(!CommonDataContext.customers.get(customerId).isRenting){
            throw new NotRentingEx();
        }
        CommonDataContext.customers.get(customerId).isRenting = false;
        CommonDataContext.customers.get(customerId).rentedCurrently = null;
        CommonDataContext.cars.get(carId).isRented = false;
    }

    @Override
    public Customer getCustomerByid(int customerId) throws NoIndexFoundEx, TException {
        if(!CommonDataContext.customers.containsKey(customerId)){
            throw new NoIndexFoundEx("customerId");
        }
        return CommonDataContext.customers.get(customerId);
    }
}
