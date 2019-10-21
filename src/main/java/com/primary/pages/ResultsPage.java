package com.primary.pages;

import com.primary.model.searchItems.FEItem;
import com.primary.webdriver.ExtendedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends Page{

    @FindBy(className = "breadcrumb__title")
    private WebElement breadcrumbTitle;

    @FindBy(xpath = "//*[@id='id_state']//a[@title='Capital Federal']")
    private WebElement capitalFederalFilter;

    @FindBy(className = "results-item")
    private List<WebElement> itemList;

    protected ResultsPage(ExtendedWebDriver webDriver) {
        super(webDriver);
    }

    public String getBreadcrumbTitle(){
        return breadcrumbTitle.getText();
    }

    public void applyCapitalFederalFilter(){
        capitalFederalFilter.click();
    }

    public List<FEItem> getItemList(){
        List<FEItem> items = new ArrayList<>();
        for (WebElement w:itemList) {
            items.add(new FEItem(
                    w.findElement(By.className("main-title")).getText(),
                    Double.valueOf(w.findElement(By.className("price__fraction")).getText()),
                    w.findElement(By.xpath("div")).getAttribute("id")
            ));
        }
        return  items;
    }

    public ItemPage selectItemByTitle(String title){
        itemList.stream().filter(x->x.findElement(By.className("main-title")).getText().equals(title)).findFirst().get().findElement(By.className("main-title")).click();
        return new ItemPage(webDriver);
    }

}
