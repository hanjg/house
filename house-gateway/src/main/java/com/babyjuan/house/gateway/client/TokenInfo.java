package com.babyjuan.house.gateway.client;

import java.util.Arrays;
import java.util.Date;

public class TokenInfo {

    private boolean active;

    private Date exp;

    private String user_name;

    private String[] authorities;

    private String client_id;

    private String[] scope;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String[] getScope() {
        return scope;
    }

    public void setScope(String[] scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
                "active=" + active +
                ", exp=" + exp +
                ", user_name='" + user_name + '\'' +
                ", authorities=" + Arrays.toString(authorities) +
                ", client_id='" + client_id + '\'' +
                ", scope=" + Arrays.toString(scope) +
                '}';
    }
}
