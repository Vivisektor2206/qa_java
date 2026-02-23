package com.example;

import java.util.List;

public interface Felines extends Animal, Predator {

    String getFamily();

    int getKittens();

    int getKittens(int kittensCount);

    List<String> getFood(String predatorType) throws Exception;
}
