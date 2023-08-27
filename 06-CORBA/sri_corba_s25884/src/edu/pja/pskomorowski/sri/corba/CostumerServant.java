package edu.pja.pskomorowski.sri.corba;

public class CostumerServant extends  _CostumerImplBase{

    private int fees;
    private int rentalTimes;
    private String name;
    private String sureName;
    private Car[] rentedCars= new Car[0];
    @Override
    public int fees() {
        return fees;
    }

    @Override
    public void fees(int newFees) {
        fees = newFees;
    }

    @Override
    public Car[] rentedCars() {
        return rentedCars;
    }

    @Override
    public void rentedCars(Car[] newRentedCars) {
        rentedCars = newRentedCars;
    }

    @Override
    public int rentalTimes() {
return  rentalTimes;
    }

    @Override
    public void increaseRental() {
        rentalTimes++;
    }

    @Override
    public void addFees(int newFees) {
        fees += newFees;
    }

    @Override
    public void payOffFees(int newFees) {
fees = 0;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void name(String newName) {
        name = newName;
    }

    @Override
    public String sureName() {
        return sureName;
    }

    @Override
    public void sureName(String newSureName) {
        sureName  = newSureName;
    }
}
