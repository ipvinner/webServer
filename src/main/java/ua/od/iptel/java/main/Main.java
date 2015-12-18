package ua.od.iptel.java.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ua.od.iptel.java.servlets.MirrorServlet;

/**
 * Created by vinner on 15.12.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        MirrorServlet mirrorServlet = new MirrorServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mirrorServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        System.out.println("Server started");
        server.join();

    }
}
