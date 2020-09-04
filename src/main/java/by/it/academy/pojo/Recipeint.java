package by.it.academy.pojo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor //сделалиio класс pojo
@NoArgsConstructor
@Entity

public final class Recipeint {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String userId;

    private String emailAdress;
    private String mobilePhone;


}
