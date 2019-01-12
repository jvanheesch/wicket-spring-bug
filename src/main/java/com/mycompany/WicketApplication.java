package com.mycompany;

import org.apache.wicket.Session;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        // add your configuration here

        this.getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }

    @Override
    public Session newSession(Request request, Response response) {
        return new MyWebSession(request);
    }

    public static class MyWebSession extends WebSession {
        @SpringBean
        private SomeService someService;

        public MyWebSession(Request request) {
            super(request);

            Injector.get().inject(this);

            // System.out.println(this.someService);
        }

        public void doStuff() {
            this.someService.doStuff();
        }
    }
}
