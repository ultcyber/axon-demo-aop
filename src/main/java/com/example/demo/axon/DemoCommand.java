package com.example.demo.axon;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DemoCommand {

    public DemoCommand(String id) {
        this.id = id;
    }

    @TargetAggregateIdentifier
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
