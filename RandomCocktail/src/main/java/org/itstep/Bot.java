package org.itstep;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bot extends TelegramLongPollingBot {
    GenerateCocktail generateCocktail = new GenerateCocktail();
    String[] array = {};
    public void onUpdateReceived(Update update) {

        //System.out.println(update.getMessage().getFrom().getFirstName() + ": " + update.getMessage().getText());
        Messages messages = new Messages();


        //Send message
        //SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        //sendMessage.setText("Привет " + update.getMessage().getFrom().getFirstName() + "\n" + update.getMessage().getText());
        if((update.getMessage().getText().equals("/help"))){
            try {
                sendMessage(messages.help(update));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (update.getMessage().getText().contains("напитки:")){
            String beverages = update.getMessage().getText();
            generateCocktail.setBeverages(beverages);
            generateCocktail.arrayOfBeverages();
        }/*else {
            try {
                sendMessage(messages.syntaxErr(update));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }*/
        if ((update.getMessage().getText().equals("/generate"))){
            try {
                sendMessage(messages.generatedCocktail(update,generateCocktail.generatedCocktail()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    /*
    public synchronized void sendMsg(String chatId, String s) {
    SendMessage sendMessage = new SendMessage();
    sendMessage.enableMarkdown(true);
    sendMessage.setChatId(chatId);
    sendMessage.setText(s);
    try {
    sendMessage(sendMessage);
    } catch (TelegramApiException e) {

    }
    }
    */


    public String getBotUsername() {
        return "randomcoctailbot";
    }

    public String getBotToken() {
        return "529835359:AAHD5XkW7F47uLQGgyjXRofoDa2vQ3d4qGQ";
    }

    public void onClosing() {

    }
}
