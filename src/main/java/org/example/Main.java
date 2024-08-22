package org.example;

import org.example.contener.ComponentContainer;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ComponentContainer.categoryController.add(UUID.randomUUID());
      // ComponentContainer.mainController.start();
    }
}