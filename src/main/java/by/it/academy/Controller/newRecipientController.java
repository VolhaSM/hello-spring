package by.it.academy.Controller;

import by.it.academy.pojo.Recipeint;
import by.it.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new-recipient.html")
public class newRecipientController {

    @Autowired
    UserService userService;

    @GetMapping
    public String showMeRecipient(){

        return "new-recipient";
    }

    @PostMapping
    public String createNewRecipient (
            @ModelAttribute Recipeint recipeint,
            Model model
    ) {

        System.out.println("New recipient " + recipeint);
        if(userService.createNewRecipient(recipeint)) {
            return "redirect:home.html";
        } else {
            model.addAttribute("errorMessage", "Cannot create a new recipient");
            return  "error-page";
        }



    }
}
