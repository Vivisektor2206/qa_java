package com.example;

import java.util.Arrays;
import java.util.List;

public class FelineImpl extends Animal implements Feline, Predator {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    @Override
    public int getKittens() {
        return getKittens(1);
    }

    @Override
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

    @Override
    public List<String> getFood(String predatorType) throws Exception {
        if ("Хищник".equals(predatorType)) {
            return Arrays.asList("Мясо", "Птица", "Рыба");
        }
        return List.of();
    }
}
