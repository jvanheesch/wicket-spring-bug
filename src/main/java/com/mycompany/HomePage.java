package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        super(parameters);

        this.add(new Link<Void>("link") {
            @Override
            public void onClick() {
                ((WicketApplication.MyWebSession) WicketApplication.MyWebSession.get()).doStuff();
            }
        });
    }
}
