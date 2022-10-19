package com.tex;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.test.context.event.BeforeTestMethodEvent;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import javax.annotation.PostConstruct;

@Component
public class MyEventsListener {

    @BeforeTestMethod
    public void handleEvent(BeforeTestMethodEvent event) {
        System.out.println("Event:");
    }

    @EventListener
    public void handleRefresh(ContextRefreshedEvent event) {
        System.out.println("Event: context refreshed " + event.getApplicationContext().getDisplayName());
    }

    @PostConstruct
    public void setup() {
        System.out.println("Event: MyEventListener post construct");
    }
}
