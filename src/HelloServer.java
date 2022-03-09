import HelloWorld.HelloPOA;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.io.BufferedWriter;
import java.io.FileWriter;

class HelloImpl extends HelloPOA {

	// implement hello_world() method
	public String hello_world() {
		return "\nHello world!!\n";
	}


	public String send_back(String one) {
		String capital = one.toUpperCase();
		return capital;
	}
}

public class HelloServer {

	public static void main(String[] args) {
		try {
			// Creamos el sistema ORB para trabajar y guardar mensajes
			ORB orb = ORB.init(args, null);

			// Inciamos POA para establecer conexión entre el objeto y el ORB
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			HelloImpl helloImpl = new HelloImpl();

			// Deshacer el marshalling de los objetos
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
			String stringified_ior = orb.object_to_string(ref);

			// Guardamos el objeto relacionado mediante el servicio de nombres a archivo.
			BufferedWriter out = new BufferedWriter(new FileWriter("server.ref"));
			out.write(stringified_ior);
			out.close();
			System.out.println("stringified_ior = " + stringified_ior);

			System.out.println("HelloServer ready and waiting ...");

			// Esperamos a que los clientes llamen al servidor.
			orb.run();
		}

		catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}

		System.out.println("HelloServer Exiting ...");

	}
}
