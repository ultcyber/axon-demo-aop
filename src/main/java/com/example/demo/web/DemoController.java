package com.example.demo.web;

import com.example.demo.axon.DemoAnotherCommand;
import com.example.demo.axon.DemoCreateCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DemoController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.OK)
    public String create(){
        String id = UUID.randomUUID().toString();
        DemoCreateCommand command = new DemoCreateCommand(id);
        commandGateway.sendAndWait(command);
        return id;
    }

    @PostMapping("notWorking/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void notWorking(@PathVariable String id){
        DemoAnotherCommand command = new DemoAnotherCommand(id);
        commandGateway.sendAndWait(command);
    }
}
