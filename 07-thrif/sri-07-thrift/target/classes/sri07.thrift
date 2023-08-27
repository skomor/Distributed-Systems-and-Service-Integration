namespace java edu.pja.sri.lab07

typedef i16 short
typedef i32 int
typedef i64 long
typedef string String
typedef bool boolean

struct RentalCar {
	1:String name;
	2:String vin;
	3:long year;
    4:String brand,
	5:bool isRented
}

struct CarsList{
	1:list<RentalCar> cars;
}

struct CustomerList{
	1:list<Customer> customers;
}

struct Customer {
    1:String name;
	2:String sureName;
    3:int bornYear;
    4:long fees;
    5:bool isRenting;
	6:CarsList rentedCarsInPast;
	7:optional RentalCar rentedCurrently;
}
exception AlreadyRentedEx {
1: string why
}
exception AlreadyRentingEx{
1: string why
}
exception NotRentingEx{
1: string why
}
exception NotRentedEx{
1: string why
}
exception NotExistsEx{
1: string why
}
exception NoIndexFoundEx{
1: string why
}

service RentalCompanyService {
	CarsList getAllCars(),
	int addNewCustomer(1:Customer customer),
	void removeCustomer( 1:int customerId) throws (1:NotExistsEx ar),
	void rentCar(1:int carId,2:int customerId ) throws (1:AlreadyRentedEx ar, 2:AlreadyRentingEx aring, 3:NoIndexFoundEx id),
	CarsList getRentedCarsBy(1:int customerId) throws (1:NoIndexFoundEx id),
	void unrentCar(1:int carId,2:int customerId ) throws (1:NotRentingEx ar, 2:NoIndexFoundEx id),
	Customer getCustomerByid(1:int customerId) throws (1:NoIndexFoundEx id),
}

service PrivateRentalCompanyService{
	CustomerList getAllCustomers(),
	int addNewRentalCar(1: RentalCar car),
	void removeCar(1:int carId) throws (1:NotExistsEx ar, 2:NoIndexFoundEx id),
	Customer getWhoIsRenting(1:int carId) throws (1:NoIndexFoundEx id, 2:NotRentedEx nre )
}