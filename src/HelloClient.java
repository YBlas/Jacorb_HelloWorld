import HelloWorld.*;

import org.omg.CORBA.*;

import java.io.*;
import java.util.Scanner;


public class HelloClient {
    
    public static void main(String[] args) {
	try {
	    // Creamos el sistema ORB para trabajar y guardar mensajes
	    ORB orb = ORB.init(args, null);
	    
	    // Comprobamos si al objeto se le ha aplicado marshalling para pasarlo como string.
	    BufferedReader in = new BufferedReader(new FileReader("server.ref"));
      	    String stringified_ior = in.readLine();
      	    System.out.println("stringified_ior = " + stringified_ior);

	    // Obtenemos referencia del objeto para el servicio de nombres.
      	    org.omg.CORBA.Object server_ref = 		
		orb.string_to_object(stringified_ior);
	    Hello server = 
		HelloWorld.HelloHelper.narrow(server_ref);

	    // Llamamos a la función creada en el servidor enviandole el dato que necesita y guardando el que recibimos.
		Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
	    String respuesta = server.send_back(inputString);
	    System.out.println(respuesta);
	    
	} catch (Exception e) {
	    System.out.println("ERROR : " + e) ;
	    e.printStackTrace(System.out);
	}
    }
    
}
