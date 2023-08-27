package edu.pja.sri.lab07.server.handlers;

import edu.pja.sri.lab07.*;
import edu.pja.sri.lab07.repo.CommonDataContext;
import org.apache.thrift.TException;

import java.util.List;

public class PrivateRentalCompanyHandler implements PrivateRentalCompanyService.Iface {
    @Override
    public CustomerList getAllCustomers() throws TException {
        return CommonDataContext.GetCustomers();
    }

    @Override
    public int addNewRentalCar(RentalCar car) throws TException {
        int id = car.hashCode();
        CommonDataContext.cars.put(id, car);
        return id;
    }


    @Override
    public void removeCar(int carId) throws NotExistsEx,  TException {
        if(!CommonDataContext.cars.containsKey(carId)){
            throw new NotExistsEx();
        }
        CommonDataContext.cars.remove(carId);
    }

    @Override
    public Customer getWhoIsRenting(int carId) throws NotExistsEx, NotRentedEx ,TException {
        if(!CommonDataContext.cars.get(carId).isRented)
            throw new NotRentedEx();
        return CommonDataContext.GetWhoIsRenting(carId);
    }

}
