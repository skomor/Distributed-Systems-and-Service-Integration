package edu.pja.pskomorowski.sri.corba;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException, InvalidName, org.omg.CosNaming.NamingContextPackage.InvalidName, CannotProceed, NotFound {

        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
        RentalCarServant var = new RentalCarServant();
        RentalCarServant var2 = new RentalCarServant();
        CostumerServant as = new CostumerServant();
        orb.connect(var);
        orb.connect(as);

        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContext ncRef = NamingContextHelper.narrow(objRef);
        NameComponent nc = new NameComponent("CostumerServant", "");
        NameComponent path[] = {nc};
        ncRef.rebind(path, as);
        NameComponent nc2 = new NameComponent("RentalCarServant", "");
        NameComponent path2[] = {nc2};
        ncRef.rebind(path2, var);
        NameComponent nc3 = new NameComponent("RentalCarServant2", "");
        NameComponent path3[] = {nc3};
        ncRef.rebind(path3, var2);


        Object sync = new Object();
        synchronized (sync) {
            sync.wait();
        }
    }
}
