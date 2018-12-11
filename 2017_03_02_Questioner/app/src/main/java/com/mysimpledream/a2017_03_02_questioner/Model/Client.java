package com.mysimpledream.a2017_03_02_questioner.Model;

import java.io.Serializable;

/**
 * Created by masoud on 2017-03-02.
 */

public class Client implements Serializable {

    private int clientNumber;
    private String email;
    private String movieType;

    public Client() {
    }

    public Client(int clientNumber, String email, String  type) {
        this.clientNumber = clientNumber;
        this.email = email;
        this.movieType = type;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return movieType;
    }

    public void setType(String type) {
        this.movieType = type;
    }

    @Override
    public String toString() {
        return  "clientNumber: " + clientNumber +
                ", email: " + email +
                ", type: " + movieType +
                "\n";
    }


}
