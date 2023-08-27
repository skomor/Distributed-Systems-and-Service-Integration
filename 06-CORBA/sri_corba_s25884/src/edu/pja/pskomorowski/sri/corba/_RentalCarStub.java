package edu.pja.pskomorowski.sri.corba;

import edu.pja.pskomorowski.sri.corba.RentalCarPackage.*;

/**
* _RentalCarStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RentalCar.idl
* Friday, 17 June 2022 22:49:27 o'clock CEST
*/

public class _RentalCarStub extends org.omg.CORBA.portable.ObjectImpl implements RentalCar
{

  public int priceForDay ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_priceForDay", true);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return priceForDay (        );
            } finally {
                _releaseReply ($in);
            }
  } // priceForDay

  public void priceForDay (int newPriceForDay)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_set_priceForDay", true);
                $out.write_long (newPriceForDay);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                priceForDay (newPriceForDay        );
            } finally {
                _releaseReply ($in);
            }
  } // priceForDay

  public boolean isForRent ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_isForRent", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return isForRent (        );
            } finally {
                _releaseReply ($in);
            }
  } // isForRent

  public void isForRent (boolean newIsForRent)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_set_isForRent", true);
                $out.write_boolean (newIsForRent);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                isForRent (newIsForRent        );
            } finally {
                _releaseReply ($in);
            }
  } // isForRent

  public int rentedTimes ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_rentedTimes", true);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return rentedTimes (        );
            } finally {
                _releaseReply ($in);
            }
  } // rentedTimes

  public void rentedTimes (int newRentedTimes)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_set_rentedTimes", true);
                $out.write_long (newRentedTimes);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                rentedTimes (newRentedTimes        );
            } finally {
                _releaseReply ($in);
            }
  } // rentedTimes

  public Car CarStruct ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_CarStruct", true);
                $in = _invoke ($out);
                Car $result = CarHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return CarStruct (        );
            } finally {
                _releaseReply ($in);
            }
  } // CarStruct

  public void CarStruct (Car newCarStruct)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_set_CarStruct", true);
                CarHelper.write ($out, newCarStruct);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                CarStruct (newCarStruct        );
            } finally {
                _releaseReply ($in);
            }
  } // CarStruct

  public void rent (Costumer cost) throws AlreadyRented, IsNotForRental
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("rent", true);
                CostumerHelper.write ($out, cost);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:RentalCar/AlreadyRented:1.0"))
                    throw AlreadyRentedHelper.read ($in);
                else if (_id.equals ("IDL:RentalCar/IsNotForRental:1.0"))
                    throw IsNotForRentalHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                rent (cost        );
            } finally {
                _releaseReply ($in);
            }
  } // rent

  public int priceForDays (int days)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("priceForDays", true);
                $out.write_long (days);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return priceForDays (days        );
            } finally {
                _releaseReply ($in);
            }
  } // priceForDays

  public void unrent () throws NotRented
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("unrent", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:RentalCar/NotRented:1.0"))
                    throw NotRentedHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                unrent (        );
            } finally {
                _releaseReply ($in);
            }
  } // unrent

  public Person currRenting ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("currRenting", true);
                $in = _invoke ($out);
                Person $result = PersonHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return currRenting (        );
            } finally {
                _releaseReply ($in);
            }
  } // currRenting

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:RentalCar:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _RentalCarStub
