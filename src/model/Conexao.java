/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MGF
 */
public class Conexao {
    private String host;
    private String banco;
    private String user;
    private String pass;
    private Integer port;
    
    public Conexao(){}

    public Conexao(String host, String banco, String user, String pass, Integer port) {
        this.host = host;
        this.banco = banco;
        this.user = user;
        this.pass = pass;        
        this.port = port;
        if(this.port == 0) this.port = 3306;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
       
    
}
