package academy.dd.fibonacci.jetty;

import academy.dd.fibonacci.rest.FibonacciService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * Created by stevewalton on 20/07/2017.
 */
public class EmbeddedJetty {

    private static Logger LOGGER = LoggerFactory.getLogger(FibonacciService.class);
    private Server jettyServer;

    public EmbeddedJetty(int portNumber) {
        jettyServer = new Server(new InetSocketAddress("0.0.0.0", portNumber));
    }

    public void start() throws Exception {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("academy.dd.fibonacci.rest");


        ServletHolder restServlet = new ServletHolder(new ServletContainer(resourceConfig));

        ServletContextHandler restContext = new ServletContextHandler(jettyServer, "/*");
        restContext.addServlet(restServlet, "/*");
        jettyServer.start();
        LOGGER.info("Fibonacci service has started, and is available on {}", jettyServer.getURI());
        jettyServer.join();
    }
}
