package by.instasite.login;

import by.instasite.database.Authorization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model) {
    model.addAttribute("login", new LogIn());
        return "login";
    }

    @RequestMapping (value = "/login", method = RequestMethod.POST)
    public String LoginSubmit(@ModelAttribute LogIn login, Model model) {
        model.addAttribute("login", login);
        if (!new Authorization().CheckCredentials(login.getUsername(), login.getPassword())) {
            return "login";
        } else return "mainpage";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String Registration (Model model){
        model.addAttribute("register", new LogIn());
        return "register";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String RegistrationSubmit (@ModelAttribute LogIn registration, Model model){
        model.addAttribute("register", registration);
        new Authorization().CreateNewUser(registration.getUsername(),registration.getPassword(),registration.getEmail(),registration.getCountry(),registration.getImageUrl());
        return "mainpage";
    }
}