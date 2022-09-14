package ch.juliusbaer.ultimatemonitoringapp.Controllers;

import ch.juliusbaer.ultimatemonitoringapp.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/createUser")
public class UserController {

    private User user;

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String getUsers(Model model) {
        model.addAttribute("user", user);
        return "user";
    }

    /*
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute User user) {
        User user = userService.createUser(userInfo);
        return "redirect:/users/";
    }
     */
}