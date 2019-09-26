package com.example.demo.axon;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class EmptyEvent {
    public EmptyEvent(String id) {
        this.id = id;
    }

    @TargetAggregateIdentifier
    private String id;
}
