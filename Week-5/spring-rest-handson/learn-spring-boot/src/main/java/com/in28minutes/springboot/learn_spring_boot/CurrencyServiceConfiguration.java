package com.in28minutes.springboot.learn_spring_boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// currency-service.url=
// currency-service.username=
// currency-service.key=

@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {

    private String url;
    private String username;  // ✔ corrected spelling
    private String key;

    // getters & setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {   // ✔ corrected getter
        return username;
    }

    public void setUsername(String username) {   // ✔ corrected setter
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
