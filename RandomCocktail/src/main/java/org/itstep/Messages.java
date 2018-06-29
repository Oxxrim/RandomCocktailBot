package org.itstep;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;


public class Messages {

    public SendMessage help(Update update){
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText("Привет " + update.getMessage().getFrom().getFirstName() + "\n" + "Ответь мне и в сообщение введи 'напитки:' после ':' перечисли напитки через ','" + "\n" + "Для генерации своего напитка введи '/generate'");
        return sendMessage;
    }

    public SendMessage syntaxErr(Update update){
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText("Проверьте правильность ввода 'напитки:'");
        return sendMessage;
    }

    public SendMessage generatedCocktail(Update update, String cocktail){
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        if (!cocktail.equals("")){
            sendMessage.setText(update.getMessage().getFrom().getFirstName() + " твой коктейль: " + cocktail);
            return sendMessage;
        }else{
            sendMessage.setText("Ты счастливчик, ты пропускаешь !!!");
            return sendMessage;
        }
    }

    public SendMessage accept(Update update){
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText("Напитки приняты!!!");
        return sendMessage;
    }
}
