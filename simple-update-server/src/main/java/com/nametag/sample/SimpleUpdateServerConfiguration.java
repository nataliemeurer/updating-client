package com.nametag.sample;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;


public class SimpleUpdateServerConfiguration extends Configuration {

    private String adminSecret;

    @JsonProperty("adminSecret")
    public String getAdminSecret() {
        return adminSecret;
    }

    @JsonProperty("adminSecret")
    public void setAdminSecret(String adminSecret) {
        this.adminSecret = adminSecret;
    }


}
