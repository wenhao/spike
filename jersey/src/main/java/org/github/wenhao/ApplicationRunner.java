package org.github.wenhao;

import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;
import static org.glassfish.jersey.server.ServerProperties.BV_SEND_ERROR_IN_RESPONSE;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class ApplicationRunner
{
    public static void main(String[] args)
    {
        ResourceConfig resourceConfig = new ResourceConfig()
                .packages("org.github.wenhao.api")
                .property(BV_SEND_ERROR_IN_RESPONSE, true)
                .registerClasses(JacksonFeature.class, EntityFilteringFeature.class);

        ServletContainer servletContainer = new ServletContainer(resourceConfig);
        ServletHolder servletHolder = new ServletHolder(servletContainer);

        ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);
        servletContextHandler.setContextPath("/");

        servletContextHandler.addServlet(servletHolder, "/rest/*");

        Server server = new Server(8080);
        server.setHandler(servletContextHandler);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            server.destroy();
            e.printStackTrace();
        }
    }
}
