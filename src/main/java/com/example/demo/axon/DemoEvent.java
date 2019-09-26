package com.example.demo.axon;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DemoEvent {

    public DemoEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @TargetAggregateIdentifier
    private String id;
}
