package by.it.academy.service;

import by.it.academy.pojo.Recipeint;

public class SMSMessageSenderImpl implements MessageSender {
    @Override
    public void send(Recipeint recipeint, Message message) {
        System.out.println("Send sms");
    }
}
