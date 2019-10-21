package com.primary.utils;

import org.testng.annotations.DataProvider;


public class DataProviders {

    @DataProvider(name = "CategoriesDataTest")
    public static Object[][] categoriesDataTest() {
        return new Object[][]
                {
                        { "Hogar y Electrodomésticos", "Muebles para Exterior" },
                        { "Herramientas e Industrias", "Equipamiento Comercial" },
                        { "Tecnología", "Celulares y Smartphones" },
                        //{ "Belleza y Cuidado Personal", "Perfumes Importados" }, 20/10/29 no es una categoria padre
                        { "Juguetes y Bebés", "Cuarto del Bebé" },
                };
    }

}
