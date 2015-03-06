package com.traitify;
import org.javalite.activejdbc.Base;

import static spark.Spark.get;

public class HelloWorld {
    public static void main(String[] args) {
        get("/hello", (req, res) -> {
          Base.open("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/awesome",
                "carson",
                "mypasseasy");
          String response = "Hello World There Are Now " + Employee.findAll() + " Users";
          Base.close();
          return response;
        });
    }
}
