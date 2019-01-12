package com.mycompany;

public class SomeService {
    private final String test;

    public SomeService(String test) {
        this.test = test;
    }

    /**
     * This results in
     * com.mycompany.Wicket_Proxy_SomeService$$EnhancerByCGLIB$$2fd35ff1@1873c3dd
     * null
     * but it should result in
     * com.mycompany.SomeService@6f0279ed
     * abc
     */
    public void doStuff() {
        System.out.println(this);
        System.out.println(test);
    }
}
