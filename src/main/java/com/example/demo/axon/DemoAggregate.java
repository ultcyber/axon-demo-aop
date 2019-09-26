package com.example.demo.axon;

import com.example.demo.aop.TestAnnotation;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class DemoAggregate {

    @AggregateIdentifier
    private String id;

    protected DemoAggregate() {
    }

    @CommandHandler
    public DemoAggregate(DemoCreateCommand command) {
        DemoEvent event = new DemoEvent(command.getId());
        apply(event);
    }

    @CommandHandler
    public void notWorking(DemoAnotherCommand command){
        apply(new EmptyEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(DemoEvent event){
        id = event.getId();
        apply(new EmptyEvent(event.getId()));
    }

    @EventHandler
    @TestAnnotation
    public void on(EmptyEvent emptyEvent){
        System.out.println("Empty event!");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
