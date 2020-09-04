package by.it.academy.Controller;

import by.it.academy.ApplicationConfiguration;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/home.html", method = RequestMethod.GET)
    public ModelAndView homePage(ModelAndView modelAndView) {
        System.out.println("Call home page");

        modelAndView.addObject("greeting", "I Love Spring and summer!");
        modelAndView.setViewName("home");

        return modelAndView;

    }
}
