package by.it.academy.service;

import by.it.academy.pojo.Recipeint;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageSenderImpl implements MessageSender {


    @Override
    public void send(Recipeint recipeint, Message message) {
        if (recipeint == null || recipeint.getEmailAdress() == null||
                "".equals(recipeint.getEmailAdress())){

            throw  new IllegalArgumentException("email cannot be empty");
        }
        System.out.println("Send by email to:" + recipeint);
        System.out.println("Message content:" + message);
    }
}
