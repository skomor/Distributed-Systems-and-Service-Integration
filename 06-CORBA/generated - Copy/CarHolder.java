
/**
* CarHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RentalCar.idl
* Friday, 17 June 2022 23:01:07 o'clock CEST
*/

public final class CarHolder implements org.omg.CORBA.portable.Streamable
{
  public Car value = null;

  public CarHolder ()
  {
  }

  public CarHolder (Car initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CarHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CarHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CarHelper.type ();
  }

}