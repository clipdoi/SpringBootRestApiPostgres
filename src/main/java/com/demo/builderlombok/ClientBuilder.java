package com.demo.builderlombok;

import com.demo.models.Category;
import lombok.Builder;

public class ClientBuilder {

    @Builder(builderMethodName = "builder")
    public static Category newClient(int id, String name) {
        return new Category(id, name);
    }

    public static void main(String[] args) {
        Category testImmutableClient = ClientBuilder.builder()
                .id(4)
                .name("Camera")
                .build();
        System.out.println("id: "+testImmutableClient.getId()+ " name: "+testImmutableClient.getName());
    }
}
