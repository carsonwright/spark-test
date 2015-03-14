package com.traitify;

import com.mchange.v2.c3p0.DataSources;
import org.javalite.activejdbc.Base;

import javax.sql.DataSource;

import java.sql.SQLException;

import static spark.Spark.get;

public class HelloWorld {

    public static void main(String[] args) throws SQLException {
        DataSource dataSourceUnpooled = DataSources.unpooledDataSource("jdbc:postgresql://localhost:5432/awesome", "carson", "mypasseasy");
        DataSource dataSourcePooled = DataSources.pooledDataSource(dataSourceUnpooled); //init the connection pool
        get("/hello", (req, res) -> {
          Base.open(dataSourcePooled); //get connection from pool
          String response = "Hello World There Are Now " + Employee.findAll() + " Users";
          Base.close();
          return response;
        });
    }
}
