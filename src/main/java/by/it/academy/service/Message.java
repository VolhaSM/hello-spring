package by.it.academy.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@ToString
@Builder
public class Message {

    private String subject;
    private String content;


}
