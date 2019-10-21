package com.primary.pages;

import com.primary.webdriver.ExtendedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Page{

    @FindBy(xpath = "//a[@data-js='nav-menu-categories-trigger']")
    private WebElement categoryButton;

    @FindBy(xpath = "//ul[starts-with(@class,'nav-categs-departments__list')][2]/li")
    private List<WebElement> categoryList;

    @FindBy(xpath = "//article[starts-with(@class,'nav-categs-detail')]")
    private List<WebElement> subCategoryArticleList;


    protected HomePage(ExtendedWebDriver webDriver) {
        super(webDriver);
    }

    public ResultsPage getResultsForCategoryAndSubcategory(String category, String subCategory){
        selectCategoryByKeyword(category);
        return selectSubCategory(subCategory);
    }

    private void selectCategoryByKeyword(String category){
        categoryButton.click();
        for(WebElement e:categoryList){
            if(e.findElement(By.tagName("a")).getText().equalsIgnoreCase(category)) {
                e.click();
                break;
            }
        }
    }

    private ResultsPage selectSubCategory(String subCategory){
        List<WebElement> subCategoryList = new ArrayList<>();
        subCategoryArticleList.forEach(x->{
            subCategoryList.add(x.findElement(By.xpath("h2/a")));
            x.findElements(By.xpath("ul/li")).forEach(y-> subCategoryList.add(y));
        });
        subCategoryList.stream().filter(x->x.getText().equalsIgnoreCase(subCategory)).findAny().get().click();
        return new ResultsPage(this.webDriver);
    }

}
