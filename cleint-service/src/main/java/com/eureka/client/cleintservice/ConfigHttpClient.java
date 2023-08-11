package com.eureka.client.cleintservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@Configuration
public class ConfigHttpClient {
    @Bean
    public HttpClient httpClient() {
    return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
    }
}
