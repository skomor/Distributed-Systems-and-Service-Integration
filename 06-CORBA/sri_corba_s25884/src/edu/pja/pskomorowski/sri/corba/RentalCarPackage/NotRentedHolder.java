package edu.pja.pskomorowski.sri.corba.RentalCarPackage;

/**
* RentalCarPackage/NotRentedHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RentalCar.idl
* Friday, 17 June 2022 22:49:28 o'clock CEST
*/

public final class NotRentedHolder implements org.omg.CORBA.portable.Streamable
{
  public NotRented value = null;

  public NotRentedHolder ()
  {
  }

  public NotRentedHolder (NotRented initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = NotRentedHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    NotRentedHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return NotRentedHelper.type ();
  }

}
