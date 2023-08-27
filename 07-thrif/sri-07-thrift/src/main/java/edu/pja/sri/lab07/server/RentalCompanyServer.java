package edu.pja.sri.lab07.server;

import edu.pja.sri.lab07.PrivateRentalCompanyService;
import edu.pja.sri.lab07.RentalCompanyService;
import edu.pja.sri.lab07.server.handlers.PrivateRentalCompanyHandler;
import edu.pja.sri.lab07.server.handlers.RentalCompanyHandler;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

// Generated code

public class RentalCompanyServer {

	  public static PrivateRentalCompanyHandler handlerPrivate;
	  public static RentalCompanyHandler handlerPublic;

	  public static PrivateRentalCompanyService.Processor processorPriv;
	  public static RentalCompanyService.Processor processorPublic;

	  public static void main(String [] args) {
	    try {
			handlerPrivate = new PrivateRentalCompanyHandler();
			handlerPublic = new RentalCompanyHandler();
			processorPublic = new RentalCompanyService.Processor(handlerPublic);
			processorPriv = new PrivateRentalCompanyService.Processor(handlerPrivate);

	      Runnable simple = new Runnable() {
	        public void run() {
				try {
					simple(processorPublic,processorPriv );
				} catch (TTransportException e) {
					e.printStackTrace();
				}
	        }
	      };      
	     
	      new Thread(simple).start();
	    } catch (Exception x) {
	      x.printStackTrace();
	    }
	  }

	  public static void simple(RentalCompanyService.Processor publicRentalProcessor, PrivateRentalCompanyService.Processor privateRentalProcessor)throws TTransportException {
	    try {
			TMultiplexedProcessor processor = new TMultiplexedProcessor();
			TServerTransport serverTransport = new TServerSocket(9090);

			TServer server = new TThreadPoolServer(new     TThreadPoolServer.Args(serverTransport).processor(processor));

			processor.registerProcessor("PublicRental", new   RentalCompanyService.Processor<RentalCompanyService.Iface>(new RentalCompanyHandler()));
			processor.registerProcessor("PrivateRental", new  PrivateRentalCompanyService.Processor<PrivateRentalCompanyService.Iface>(new PrivateRentalCompanyHandler()));

	      System.out.println("Starting the multiplexed server...");
			server.serve();

		} catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	 
	}