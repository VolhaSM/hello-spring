package by.it.academy.Controller;

import by.it.academy.pojo.Recipeint;
import by.it.academy.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;


@Controller
public class RecipientController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}/recipient.html")
    public ModelAndView showRecipientForm(
            @PathVariable String id,
            ModelAndView modelAndView
    ) {
        Recipeint recipeint = userService.get(id);
        modelAndView.addObject("user", recipeint);
        modelAndView.setViewName("recipient");

        return modelAndView;

    }

    @PostMapping("/recipient.html")
    @SneakyThrows
    public String updateRecipient(
            @ModelAttribute Recipeint recipeint,
            @RequestParam("image") MultipartFile file
            )  {
        byte[] bytes = file.getBytes();
        String fileName = file.getOriginalFilename();


        System.out.println("File location: "  + fileName);
        saveToDisk(bytes, fileName);

        userService.update(recipeint);
        return "redirect: recipient-list.html";

    }

    @SneakyThrows
    private void saveToDisk(byte[] bytes,  String fileName) {

        FileOutputStream fileOutputStream
                = new FileOutputStream(fileName);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();

    }
}
