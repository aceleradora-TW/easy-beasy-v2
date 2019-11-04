package com.thoughtworks.aceleradora.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDataBase {

    private Connection connection = null;
    private Statement statement;
    private ResultSet result;
    private String strConnection;
    private String address;
    private String user;
    private String password;
    private String driverjdbc;

    public ConnectionDataBase(String address, String port, String dataBase, String user, String password){
        setStrConnection("jdbc:postgresql://" + address + ";" + port + "/" + dataBase);
        setAddress(address);
        setPassword(password);
        setUser(user);
        setDriverjdbc("org.postgresql.Driver");
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public String getStrConnection(){
        return strConnection;
    }

    public void setStrConnection(String strConnection){
        this.strConnection = strConnection;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverjdbc(){
        return getDriverjdbc();
    }

    public void setDriverjdbc(String driverjdbc) {
        this.driverjdbc = driverjdbc;
    }
}
