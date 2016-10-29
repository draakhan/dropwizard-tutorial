package info.draakhan.cli;

import io.dropwizard.cli.Command;
import io.dropwizard.setup.Bootstrap;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;

public class HelloCommand extends Command {
    
    public static final String USER_ARGUMENT = "user";
    
    public HelloCommand() {
        super("hello", "Prints a greeting");
    }
    
    @Override
    public void configure(Subparser subparser) {
        subparser.addArgument("-u", "--user")
            .dest(USER_ARGUMENT)
            .type(String.class)
            .required(true)
            .help("The user of the program");
    }
    
    @Override
    public void run(Bootstrap<?> bootstrap, Namespace namespace) throws Exception {
        System.out.println("Hello " + namespace.getString(USER_ARGUMENT));
    }
}
