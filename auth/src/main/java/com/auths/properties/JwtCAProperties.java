package com.auths.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "exam.jwt")
public class JwtCAProperties {


    private String keyPairName;



    private String keyPairAlias;


    private String keyPairSecret;


    private String keyPairStoreSecret;

}