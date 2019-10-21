package com.primary.backend;

import com.primary.core.TestBase;
import com.primary.model.searchItems.SearchResponse;
import com.primary.model.searchItems.ItemResponse;
import com.primary.services.ItemService;
import com.primary.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class BackendTest extends TestBase {

    @Autowired
    private SearchService searchService;

    @Autowired
    private ItemService itemService;

    @Test(groups = "backend")
    public void validarQueLaApiDevuelvaResultadosYQueLosResultadosNoExcedanElLimiteDeLaApi(){
        SearchResponse searchResponse = searchService.getResultbyKeyword("iphone");
        assertTrue(searchResponse.getPaging().getTotal() > 0);
        assertTrue(searchResponse.getPaging().getLimit() >= searchResponse.getResults().size());
    }

    @Test(groups = "backend")
    public void validarQueAlConsultarUnItemAleatorioDeLaApiDeResultadosEsteCoincidaConElDeLaApiDeDetalleDeProducto(){
        ItemResponse itemFromSearchResults = searchService.getResultbyKeyword("iphone x").getResults().stream().findAny().get();
        ItemResponse itemResponse = itemService.getItemById(itemFromSearchResults.getId());
        assertEquals(itemFromSearchResults.getTitle(), itemResponse.getTitle());
        assertEquals(itemFromSearchResults.getPrice(), itemResponse.getPrice());
        assertEquals(itemFromSearchResults.getAccepts_mercadopago(), itemResponse.getAccepts_mercadopago());
        assertEquals(itemFromSearchResults.getCurrency_id(), itemResponse.getCurrency_id());
        assertEquals(itemFromSearchResults.getShipping().getFree_shipping(), itemResponse.getShipping().getFree_shipping());
    }
}
