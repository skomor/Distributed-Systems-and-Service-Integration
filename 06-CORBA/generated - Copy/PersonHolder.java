
/**
* PersonHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RentalCar.idl
* Friday, 17 June 2022 23:01:07 o'clock CEST
*/

public final class PersonHolder implements org.omg.CORBA.portable.Streamable
{
  public Person value = null;

  public PersonHolder ()
  {
  }

  public PersonHolder (Person initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PersonHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PersonHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PersonHelper.type ();
  }

}
