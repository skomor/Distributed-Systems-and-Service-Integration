
/**
* _PersonImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RentalCar.idl
* Friday, 17 June 2022 23:01:07 o'clock CEST
*/

public abstract class _PersonImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements Person, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _PersonImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_name", new java.lang.Integer (0));
    _methods.put ("_set_name", new java.lang.Integer (1));
    _methods.put ("_get_sureName", new java.lang.Integer (2));
    _methods.put ("_set_sureName", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Person/_get_name
       {
         String $result = null;
         $result = this.name ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // Person/_set_name
       {
         String newName = in.read_string ();
         this.name (newName);
         out = $rh.createReply();
         break;
       }

       case 2:  // Person/_get_sureName
       {
         String $result = null;
         $result = this.sureName ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // Person/_set_sureName
       {
         String newSureName = in.read_string ();
         this.sureName (newSureName);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Person:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _PersonImplBase