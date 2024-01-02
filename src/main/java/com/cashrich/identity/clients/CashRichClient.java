package com.cashrich.identity.clients;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CashRichClient {

    private static final String API_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
    private static final String API_KEY = "27ab17d1-215f-49e5-9ca4-afd48810c149";

    public static void main(String[] args) {
        String symbols = "BTC,ETH,LTC";
        String apiUrlWithSymbols = String.format("%s?symbol=%s", API_URL, symbols);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", API_KEY);

        ResponseEntity<String> response = makeApiRequest(apiUrlWithSymbols, HttpMethod.GET, headers, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            System.out.println("API Response: " + responseBody);
        } else {
            System.err.println("API Request Failed. Status Code: " + response.getStatusCode());
        }
    }

    private static <T> ResponseEntity<T> makeApiRequest(String url, HttpMethod method, HttpHeaders headers, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        return restTemplate.exchange(url, method, null, responseType);
    }


    private static ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);
        return factory;
    }
}

