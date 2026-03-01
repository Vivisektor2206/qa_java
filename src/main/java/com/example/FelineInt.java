package com.example;

import java.util.List;

public interface FelineInt {
    String getFamily();

    int getKittens();

    int getKittens(int kittensCount);

    List<String> getFood(String predatorType) throws Exception;
    List<String> eatMeat() throws Exception;
}
