package project.Myprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home()
    {
    return "home";
    }

    @GetMapping("/join")
    public String createForm()
    {
        return "members/createMemberForm";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login/login";
    }
}
