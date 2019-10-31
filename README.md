This is demo of the Corba Hello world program written to use the Jacorb Orb.  It uses the "IOR in a file" trick.

Dr Gary Allen.
University of Huddersfield

If you don't already have it, download Jacorb from the Jacorb web site and unpack it somewhere.

Also download the library jboss-rmi-api_1.0_spec-1.0.6.Final.jar from the Maven Repository at:

    https://mvnrepository.com/artifact/org.jboss.spec.javax.rmi/jboss-rmi-api_1.0_spec/1.0.6.Final.

This is a workaround to fix an issue with Java 11 and above.

Add all the libraries from the Jacorb lib folder to the project (they are not all required, but I don't know the minmum set) **AND** add the jboss library too.

To stop Jacorb displaying extensive logging information add the following VM args to the HelloServer and HelloClient run configurations:

    -Djacorb.log.default.verbosity=2
    
That will ensure errors and warnings are displayed, but not general info.  (You might try running the code without these arguments to see the extra logging information produced.  Setting the level to 4 gives even more detail.)

Start the Server and then run the Client.  The server persists so has to be stopped externally.

