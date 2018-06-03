package com.care.open.weather.client.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.care.open.weather.client")
class ClientConfiguration {

  @Value("${httpclient.pooling.connection.default-max-per-route}")
  Integer defaultMaxPerRoute;

  @Value("${httpclient.pooling.connection.max-total}")
  Integer maxTotal;

  @Value("${httpclient.connection.timeout.millisec}")
  Integer connectionTimeout;

  @Value("${httpclient.read.timeout.millisec}")
  Integer readTimeout;

  @Value("${httpclient.connectionReuse:true}")
  Boolean connectionReuse;

  @Bean
  RestTemplate restTemplate() {

    HttpClient httpClient = getHttpClientPoolingConnectionManager();

    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
    factory.setConnectTimeout(connectionTimeout);
    factory.setReadTimeout(readTimeout);

    RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));
    restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

    return restTemplate;
  }

  private HttpClient getHttpClientPoolingConnectionManager() {

    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
    connectionManager.setMaxTotal(maxTotal);

    HttpClientBuilder httpClientBuilder = HttpClientBuilder.create().setConnectionManager(connectionManager);

    if (!connectionReuse) {

      httpClientBuilder.setConnectionReuseStrategy(NoConnectionReuseStrategy.INSTANCE);
    }

    return httpClientBuilder.build();
  }
}