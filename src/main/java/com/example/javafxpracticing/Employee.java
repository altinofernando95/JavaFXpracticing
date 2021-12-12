package com.example.javafxpracticing;

import java.util.UUID;

public class Employee
{

    public String name;
    private UUID id;

    public  Employee()
    {
        id = UUID.randomUUID();
    }

    public UUID getId()
    {
        return id;
    }

}
