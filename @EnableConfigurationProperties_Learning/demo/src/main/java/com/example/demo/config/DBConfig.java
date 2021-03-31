package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author viveksoni100
 */
@ConfigurationProperties(prefix = "db")
public class DBConfig {

    // variable based binding
    private String username;
    private String password;

    // collection based binding
    @Value("Test1, Test2")
    private List<String> others;

    private Map<String, String> map;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getOthers() {
        return others;
    }

    public void setOthers(List<String> others) {
        this.others = others;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
