package by.it.academy.service;

import by.it.academy.Repository.UserDao;
import by.it.academy.pojo.Recipeint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Receiver;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    UserDao userDao;
    public List<String> search(String searchStr) {
        return  (List<String>) userDao.findAll(searchStr)
                .stream()
                .map(o-> ((Recipeint) o).getMobilePhone() + " "
                        +((Recipeint) o).getEmailAdress())
                .collect(Collectors.toList());

    }

    public boolean createNewRecipient(Recipeint recipeint) {

        if(userDao.find(recipeint.getUserId())!= null) {
            return false;
        }

        userDao.create(recipeint);
        return true;
    }

    public List<Recipeint> getAll() {
        return userDao.findAll("");  //найди любого
    }

    public Recipeint get(String id) {
        return (Recipeint) userDao.read(Recipeint.class, id);
    }

    public void update(Recipeint recipeint) {
        userDao.update(recipeint);
    }
}
