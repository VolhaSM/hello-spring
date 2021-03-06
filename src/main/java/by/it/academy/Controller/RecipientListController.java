package by.it.academy.Controller;

import by.it.academy.pojo.Recipeint;
import by.it.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RecipientListController {

    @Autowired
    UserService userService;

    @GetMapping("/recipient-list.html")
    public ModelAndView recipientList(ModelAndView modelAndView) {

       List<Recipeint> users =  userService.getAll();
       modelAndView.setViewName("recipient-list");
       modelAndView.addObject("users", users);

       return modelAndView;
    }
}
