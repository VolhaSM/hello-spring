package by.it.academy.service;

import by.it.academy.Repository.UserDao;
import by.it.academy.pojo.Recipeint;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class NotificationCommandExecutor {

    @Autowired
    //@Value("#{emailMessageSender}")
            EmailMessageSenderImpl emailMessageSender;

    @Value("100")
    int count;

    @Autowired
    UserDao userRepository;

    @Autowired
    MessageGenerator messageGenerator;

    public boolean execute(NotificationCommand command) {
        System.out.println("Command to execute");
        System.out.println(command);

        final Recipeint recipeint = (Recipeint) userRepository.find(command.getUserId());
        final Message message = messageGenerator.generate(command.getMessageType());


        switch (command.getChannel()) {
            case SMS: {
                System.out.println("not implemented");
                break;
            }

            case EMAIL:{
                emailMessageSender.send(recipeint, message);
                break;

            }
            case VIBER:{

                System.out.println("not implemented2");
                break;
            }
            default:{
                System.out.println("No channel");

            }
        }

        System.out.println("Executed successfully");

        return  true;
    }
}
