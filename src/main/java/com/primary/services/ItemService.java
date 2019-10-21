package com.primary.services;

import com.primary.model.searchItems.ItemResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${item.by.id.endpoint}")
    private String url;

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    public ItemService() { }

    public ItemResponse getItemById(String itemId){
        LOGGER.info("Requesting item id: " + itemId);
        return restTemplate.getForObject(this.url + itemId, ItemResponse.class);
    }

}
