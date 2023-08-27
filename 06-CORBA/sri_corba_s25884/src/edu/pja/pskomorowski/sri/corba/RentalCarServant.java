package edu.pja.pskomorowski.sri.corba;

import edu.pja.pskomorowski.sri.corba.RentalCarPackage.AlreadyRented;
import edu.pja.pskomorowski.sri.corba.RentalCarPackage.IsNotForRental;
import edu.pja.pskomorowski.sri.corba.RentalCarPackage.NotRented;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentalCarServant extends _RentalCarImplBase {

    private int priceForDay;
    private int rentedTimes;
    private boolean isForRent = true;

    private Costumer rentedBy;

    private Car Car;

    @Override
    public int priceForDay() {
        return priceForDay;
    }

    @Override
    public void priceForDay(int newPriceForDay) {
        priceForDay = newPriceForDay;
    }

    @Override
    public boolean isForRent() {
        return isForRent;
    }

    @Override
    public void isForRent(boolean newIsForRent) {
        isForRent = newIsForRent;
    }

    @Override
    public int rentedTimes() {
        return rentedTimes;
    }

    @Override
    public void rentedTimes(int newRentedTimes) {
        rentedTimes = newRentedTimes;
    }

    @Override
    public Car CarStruct() {
        return Car;
    }

    @Override
    public void CarStruct(Car newCarStruct) {
        Car = newCarStruct;
    }

    @Override
    public void rent(Costumer cost) throws AlreadyRented, IsNotForRental {
        if (!isForRent)
            throw new IsNotForRental();
        if (rentedBy != null)
            throw new AlreadyRented();
        rentedBy = cost;
        rentedTimes++;
        rentedBy.increaseRental();
        Car[] rented = rentedBy.rentedCars();
        Car[] newarr = new Car[rented.length + 1];
        System.arraycopy(rented, 0, newarr, 0, rented.length);
        newarr[rented.length] = this.Car;
        rentedBy.rentedCars(newarr);
    }

    @Override
    public int priceForDays(int days) {
        return days * priceForDay;
    }

    @Override
    public void unrent() throws NotRented {
        if (rentedBy == null)
            throw new NotRented();
        Car[] rented = rentedBy.rentedCars();
        List<Car> list = new ArrayList<Car>(Arrays.asList(rented));
        list.remove(this.Car);
        rentedBy.rentedCars(list.toArray(new Car[0]));
        rentedBy = null;
    }

    @Override
    public Person currRenting() {
        return null;
    }
}
