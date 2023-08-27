package edu.pja.pskomorowski.sri.corba;

import edu.pja.pskomorowski.sri.corba.RentalCarPackage.AlreadyRented;
import edu.pja.pskomorowski.sri.corba.RentalCarPackage.IsNotForRental;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.IOException;
import java.util.Arrays;

public class Client {

    public static void main(String[] args) throws IOException, InvalidName, CannotProceed, NotFound, org.omg.CORBA.ORBPackage.InvalidName {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContext ncRef = NamingContextHelper.narrow(objRef);
        NameComponent nc = new NameComponent("RentalCarServant", "");
        NameComponent nc2 = new NameComponent("RentalCarServant2", "");
        NameComponent cosNameC = new NameComponent("CostumerServant", "");
        NameComponent path[] = {nc};
        NameComponent pat2[] = {nc2};
        NameComponent path2[] = {cosNameC};
        RentalCar car = RentalCarHelper.narrow(ncRef.resolve(path));
        RentalCar car2 = RentalCarHelper.narrow(ncRef.resolve(pat2));
        Costumer cos1 = CostumerHelper.narrow(ncRef.resolve(path2));

        cos1.name("Skomorowski");
        Car carStruct = new Car();
        carStruct.name = "Mazda";
        carStruct.vin = "123456789";

        Car carStruct2 = new Car();
        carStruct2.name = "Toyota";
        carStruct2.vin = "1131211";


        car.CarStruct(carStruct);
        car2.CarStruct(carStruct2);

        System.out.println(cos1.name() + " fees:  " + cos1.fees());

        RentCar(car, cos1);
        RentCar(car2, cos1);

        System.out.println( car.CarStruct().name + " was rented "+ car.rentedTimes() + " times" );
        System.out.println( cos1.name() + " now has to pay "+ cos1.fees() + "USD of fees" );
        System.out.println( cos1.name() + " rented "+ cos1.rentalTimes()  );
        
        System.out.println( car.CarStruct().name + " was rented "+ car.rentedTimes() + " times" );
        System.out.println( cos1.name() + " rented: " );
        for (Car rentedCar: cos1.rentedCars()
             ) {
            System.out.println( rentedCar.name);

        }

    }

    private static void RentCar(RentalCar car2, Costumer cos1) {
        if(car2.isForRent()) {
            try {
                car2.rent(cos1);
                cos1.addFees(500);
            } catch (AlreadyRented e) {
                System.out.println( car2.CarStruct().name + " is already rented");
            } catch (IsNotForRental e) {
                System.out.println( car2.CarStruct().name + " is not for rental ");
            }
        }else {
            System.out.println( car2.CarStruct().name + " was not for rent ");
        }
    }
}
