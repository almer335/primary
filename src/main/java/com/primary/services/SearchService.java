package com.primary.services;

import com.primary.model.searchItems.SearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${search.by.Keyword.endpoint}")
    private String url;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchService.class);

    public SearchService() { }

    public SearchResponse getResultbyKeyword(String keyword){
        LOGGER.info("Requesting Resulst for keyword: " + keyword);
        return restTemplate.getForObject(this.url + keyword, SearchResponse.class);
    }
}
