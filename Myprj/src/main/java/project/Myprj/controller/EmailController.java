package project.Myprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.Myprj.domain.Email;
import project.Myprj.service.EmailService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class EmailController {

    @Autowired
    EmailService emailService;


    //@RequestParam("email_ID")
    @PostMapping("/mail")
    @ResponseBody
    public Map<String, String> emailConfirm (@RequestBody Map<String, Object> param, HttpServletResponse response) throws Exception
    {
        Map<String, String> map = new HashMap<>();

        String userId = (String) param.get("email_ID");
        // mail 로 들어오면 인증이 되도록.
        emailService.sendSimpleMessage(userId);
        map.put("status","200");
        return map;
    }
    @PostMapping("/verifyCode")
    @ResponseBody
    public Map<String, String> verifyCode(@RequestBody Map<String, Object> param, HttpServletResponse response) {

        String code = (String) param.get("verifyCode");
        int result = 0;


        Optional<Email> list = emailService.findbycontent(code);
        if(list.isPresent()) {
            result = 1;
        }
        Map<String, String> map = new HashMap<>();

        map.put("result",Integer.toString(result));
        return map;
    }

}
