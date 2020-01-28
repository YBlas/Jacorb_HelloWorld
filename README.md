This is demo of the Corba Hello world program written to use the Jacorb Orb.  It uses the "IOR in a file" trick.

Dr Gary Allen.
University of Huddersfield

If running this off campus and you don't already have it, download Jacorb from the Jacorb web site and unpack it somewhere.

Also download the library jboss-rmi-api_1.0_spec-1.0.6.Final.jar from the Maven Repository at:

    https://mvnrepository.com/artifact/org.jboss.spec.javax.rmi/jboss-rmi-api_1.0_spec/1.0.6.Final.

This is a workaround to fix an issue with Java 11 and above.

To run the demo:

1.  Add all the libraries from the Jacorb lib folder to the project (they are not all required, but I don't know the minmum set) **AND** add the jboss library too.  If you are on campus this means adding the following libraries:


    /local/jacorb-3.9/lib

2.  Precompile the idl.  To do this use the terminal built into Intellij (or an external terminal if you prefer) and type:


    cd src
    <path_to_jacorb_dir>/bin/idl HelloWorld.idl

e.g. on campus we would type:

    cd src
    /local/jacorb-3.9/bin/idl HelloWorld.idl
    
3.  Start the Server and then run the Client.  The server persists so has to be stopped externally.

Note that to stop Jacorb displaying extensive logging information, add the following VM args to the HelloServer and HelloClient run configurations:


    -Djacorb.log.default.verbosity=2
    
That will ensure errors and warnings are displayed, but not general info.  (You might try running the code without these arguments to see the extra logging information produced.  Setting the level to 4 gives even more detail.)



