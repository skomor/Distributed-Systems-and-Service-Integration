package edu.pja.pskomorowski.sri.corba;
/**
* CostumerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RentalCar.idl
* Friday, 17 June 2022 23:01:07 o'clock CEST
*/

public final class CostumerHolder implements org.omg.CORBA.portable.Streamable
{
  public Costumer value = null;

  public CostumerHolder ()
  {
  }

  public CostumerHolder (Costumer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CostumerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CostumerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CostumerHelper.type ();
  }

}
