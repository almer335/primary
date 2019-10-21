package com.primary.frontend;

import com.primary.core.TestBaseFrontEnd;
import com.primary.model.searchItems.FEItem;
import com.primary.pages.HomePage;
import com.primary.pages.ItemPage;
import com.primary.pages.ResultsPage;
import com.primary.utils.DataProviders;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertEquals;

public class FrontendTest extends TestBaseFrontEnd {

    @Test(dataProvider = "CategoriesDataTest", dataProviderClass = DataProviders.class, groups = "frontend")
    public void vefiricarQueAlSeleccionarUnaCategoriaYUnaSubCategoriaDesdeLAHomeSeMuestrenLosResultadosCorrespondientes(String category, String subCategory){
        HomePage homePage = mercadolibreSiteMap.homePage();
        ResultsPage resultsPage = homePage.getResultsForCategoryAndSubcategory(category,subCategory);
        assertEquals(resultsPage.getBreadcrumbTitle(),subCategory);
    }

    @Test(groups = "frontend")
    public void VerificarQueALSeleccionarUnItemDesdeUnResultadosDeCategoriaLaPaginaDelItemCorrespondaConElSeleccionado         (){
        HomePage homePage = mercadolibreSiteMap.homePage();
        ResultsPage resultsPage = homePage.getResultsForCategoryAndSubcategory("Tecnología","Celulares y Smartphones");
        resultsPage.applyCapitalFederalFilter();
        FEItem itemSelected = resultsPage.getItemList().stream().findAny().get();
        ItemPage itemPage = resultsPage.selectItemByTitle(itemSelected.getTitle());
        assertEquals(itemPage.getTitle(),itemSelected.getTitle());
        assertEquals(itemPage.getSalePrice(),itemSelected.getPrice());
    }

}
