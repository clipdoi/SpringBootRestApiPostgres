package com.demo.builderlombok;

import lombok.Builder;

@Builder(toBuilder = true)
public class Human {

    private final int id;
    private final String name;

    public static void main(String[] args) {
        Human h1 = Human.builder()
                .name("xyz")
                .id(1)
                .build();
        Human.HumanBuilder widgetBuilder = h1.toBuilder();
        Human h2 = widgetBuilder.id(2).name("abc").build();
        System.out.println(h1.name + h2.name);
    }

}
