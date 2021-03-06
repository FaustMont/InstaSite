package by.instasite.login;

import by.instasite.database.Authorization;
import by.instasite.database.user.User;
import by.instasite.database.user.UserTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model) {
    model.addAttribute("login", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginSubmit(@ModelAttribute User login, Model model) {
        model.addAttribute("login", login);
        //String answer = new Authorization().CheckCredentials(login.getUsername(), login.getPassword());
        String answer = new UserTemplate().getDataSouse();
        if (!answer.equals("true")) {
            model.addAttribute("error",answer);
            return "login";
        } else  return "mainpage";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String Registration (Model model){
        model.addAttribute("login", new User());
        return "register";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String RegistrationSubmit (@ModelAttribute User register, Model model){
        model.addAttribute("login", register);
        if (new Authorization().CreateNewUser(register.getUsername(),register.getPassword(),register.getEmail(),register.getCountry())) {
            return "mainpage";
        } else return "register";
    }
}