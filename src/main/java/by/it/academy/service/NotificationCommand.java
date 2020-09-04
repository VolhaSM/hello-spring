package by.it.academy.service;

import lombok.Data;

@Data
public class NotificationCommand {
    //иллюстрировать жизненный цикл


    private String userId;
    private MessageType messageType;
    private Channel channel;
    private String beanName;



}
