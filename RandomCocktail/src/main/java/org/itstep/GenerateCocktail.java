package org.itstep;

import org.apache.commons.lang3.StringUtils;



public class GenerateCocktail {

    private String beverages;
    private String[] arrayOfBeverages;

    public void setBeverages(String beverages) {
        this.beverages = beverages;
    }

    public void arrayOfBeverages(){
        beverages = StringUtils.substringAfter(beverages,":").trim();
        arrayOfBeverages = beverages.split(",");

    }

    public String generatedCocktail(){
        String cocktail = "";
        int countOfBeverages = (int) (Math.random() * (arrayOfBeverages.length));
        for (int i = 0; i < countOfBeverages; i++){
            if (i == countOfBeverages - 1){
                cocktail += arrayOfBeverages[(int) (Math.random() * (arrayOfBeverages.length))] + " 50гр.";
            }else {
                cocktail += arrayOfBeverages[(int) (Math.random() * (arrayOfBeverages.length))] + " 50гр + ";
            }
        }

        return cocktail;
    }
}
