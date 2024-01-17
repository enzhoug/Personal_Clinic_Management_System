package com.pojo.medico;

public class Case {
    private int id;
    private int clientid;
    private String medicinename;
    private String casename;
    private String clientname;
    private String cliengender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getCliengender() {
        return cliengender;
    }

    public void setCliengender(String cliengender) {
        this.cliengender = cliengender;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", clientid=" + clientid +
                ", medicinename='" + medicinename + '\'' +
                ", casename='" + casename + '\'' +
                ", clientname='" + clientname + '\'' +
                ", cliengender='" + cliengender + '\'' +
                '}';
    }
}
