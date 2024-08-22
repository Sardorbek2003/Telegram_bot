package org.example;

import org.example.contener.ComponentContainer;
import org.example.util.FilePathUtil;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        ComponentContainer.categoryController.add(UUID.randomUUID());
      // ComponentContainer.mainController.start();
    }

}