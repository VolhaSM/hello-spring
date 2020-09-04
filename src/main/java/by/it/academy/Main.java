package by.it.academy;

import by.it.academy.Repository.UserDao;
import by.it.academy.pojo.Recipeint;
import by.it.academy.service.Channel;
import by.it.academy.service.MessageType;
import by.it.academy.service.NotificationCommand;
import by.it.academy.service.NotificationCommandExecutor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {

    static AnnotationConfigApplicationContext context;


    public static void main(String[] args) throws InterruptedException {

        context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class); // засетали конфиг

        createUser("user1");
        createUser("user2");


        final NotificationCommand notificationCommand = createCommand("user1");
        final NotificationCommand notificationCommand2 = createCommand("user2");


        final NotificationCommandExecutor executor =
                (NotificationCommandExecutor) context.getBean("notificationCommandExecutor");

        executor.execute((notificationCommand));
        executor.execute(notificationCommand2);

        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        context.close();
        Thread.sleep(3000);


    }

    private static void createUser(String userId) {

        UserDao userRepository = (UserDao) context.getBean("userRepository");
        Recipeint recipeint = new Recipeint(null, userId, userId + "@mail.ru", null);
        userRepository.create(recipeint);
    }


    private static NotificationCommand createCommand(String userId) {
        NotificationCommand notificationCommand = (NotificationCommand) context.getBean("notificationCommand");
        notificationCommand.setChannel(Channel.EMAIL);
        notificationCommand.setMessageType(MessageType.Order_Ready);
        notificationCommand.setUserId(userId);
        return notificationCommand;

    }


}
