package com.example;

import java.util.List;

public class Cat {

    FelineInt feline;

    public Cat(FelineInt feline) {
        this.feline = feline;
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat();
    }

}
