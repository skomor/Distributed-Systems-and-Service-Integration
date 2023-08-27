package edu.pja.sri.lab07.client;

import edu.pja.sri.lab07.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.List;

public class RentalClient {
    public static void main(String[] args) {
        try {
            TTransport transport;

            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);

            TMultiplexedProtocol mp = new TMultiplexedProtocol(protocol, "PublicRental");
            RentalCompanyService.Client rentalCompany = new RentalCompanyService.Client(mp);

            TMultiplexedProtocol mp2 = new TMultiplexedProtocol(protocol, "PrivateRental");
            PrivateRentalCompanyService.Client privateRental = new PrivateRentalCompanyService.Client(mp2);

            perform(rentalCompany, privateRental);
            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    private static void perform(RentalCompanyService.Client rentalCompanyService, PrivateRentalCompanyService.Client privateRentalCompanyService) throws TException {
        Customer cus1 = new Customer().setName("Piotr").setSureName("Skomorowski").setBornYear(1998);
        Customer cus2 = new Customer().setName("Mariusz").setSureName("Melon").setBornYear(1939);
        Customer cus3 = new Customer().setName("Tomasz").setSureName("Nolem").setBornYear(1945);
        int id1= rentalCompanyService.addNewCustomer(cus1);
        int id2= rentalCompanyService.addNewCustomer(cus2);
        int id3= rentalCompanyService.addNewCustomer(cus3);


        RentalCar firstCar = new RentalCar().setBrand("Fiat").setVin("123123").setName("Punto").setYear(2008);
        RentalCar secondCar = new RentalCar().setBrand("Honda").setVin("1243123").setName("Civic").setYear(2012);

        int car1=privateRentalCompanyService.addNewRentalCar(firstCar);
        int car2= privateRentalCompanyService.addNewRentalCar(secondCar);

        rentalCompanyService.rentCar(car1 ,id1);
        rentalCompanyService.rentCar(car2 ,id2);
        rentalCompanyService.unrentCar(car1 ,id1);
        try{
            rentalCompanyService.unrentCar(car1 ,id1);//to handle
        }
        catch(Exception ex){
            System.out.println("Handled correctly ");
        }

        System.out.println("customer "+ cus1 + "rented in past cars: "+ rentalCompanyService.getRentedCarsBy(id1));
        System.out.println("car  "+ firstCar + "is rented by: "+ privateRentalCompanyService.getWhoIsRenting(car2));
        System.out.println("all customers "+ privateRentalCompanyService.getAllCustomers());
        System.out.println("all cars "+ rentalCompanyService.getAllCars());
        System.out.println("customer "+ id1 + "current state "+ rentalCompanyService.getCustomerByid(id1));



        /*RentalCar car =  addCar(privateRentalCompanyService);
        car =  addCar2(privateRentalCompanyService);

        RentCarByFirst(rentalCompanyService, privateRentalCompanyService,car);

        System.out.println("rented by first client: " + getRentedCarsByFirst(rentalCompanyService, privateRentalCompanyService));
        System.out.println("renting "+car.name +" costumer: " +getRentingCostumer(privateRentalCompanyService,car));*/

    /*    try{
            RentCarByFirst(rentalCompanyService, privateRentalCompanyService,car); //should throw exce
        }catch(Exception e){
            System.out.println("Handlel correctly: "+ e);
        }
*/
        System.out.println(rentalCompanyService.getAllCars()); //both servers are using common context :)
    }

    private static void populateCustomers(RentalCompanyService.Client rentalCompanyService) throws TException {

    }

    private static void populateCars(PrivateRentalCompanyService.Client privateRentalCompanyService) throws TException {

    }

}
