package com.pojo.medico;

public class Client {
    private int id;
    private String clientname;
    private String clientgender;
    private int clientage;
    private int clientsalary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClientgender() {
        return clientgender;
    }

    public void setClientgender(String clientgender) {
        this.clientgender = clientgender;
    }

    public int getClientage() {
        return clientage;
    }

    public void setClientage(int clientage) {
        this.clientage = clientage;
    }

    public int getClientsalary() {
        return clientsalary;
    }

    public void setClientsalary(int clientsalary) {
        this.clientsalary = clientsalary;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientname='" + clientname + '\'' +
                ", clientgender='" + clientgender + '\'' +
                ", clientage=" + clientage +
                ", clientsalary=" + clientsalary +
                '}';
    }
}
