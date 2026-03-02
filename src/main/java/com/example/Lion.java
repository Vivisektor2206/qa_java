package com.example;

import java.util.List;

public class Lion {
    private final FelineInt feline;
    private final boolean hasMane;

    public Lion(FelineInt feline, String sex) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new IllegalArgumentException("Используйте допустимые значения пола животного — самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}