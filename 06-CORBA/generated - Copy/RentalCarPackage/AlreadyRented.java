package RentalCarPackage;


/**
* RentalCarPackage/AlreadyRented.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RentalCar.idl
* Friday, 17 June 2022 23:01:07 o'clock CEST
*/

public final class AlreadyRented extends org.omg.CORBA.UserException
{

  public AlreadyRented ()
  {
    super(AlreadyRentedHelper.id());
  } // ctor


  public AlreadyRented (String $reason)
  {
    super(AlreadyRentedHelper.id() + "  " + $reason);
  } // ctor

} // class AlreadyRented
