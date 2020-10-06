package project.Myprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import project.Myprj.domain.Member;
import project.Myprj.service.MemberService;

import java.util.List;

@Controller
public class MemberController  {

    private MemberService memberService;


    @Autowired
    PasswordEncoder passwordEncoder;


    public MemberController(MemberService memberService) {
        // Controller 가 붙어 있으므로 이를 생성하여 Contrainer에 넣는다.

        this.memberService = memberService;
    }

    @PostMapping("/join")
    public String create(@RequestParam("username") String name, @RequestParam("password") String password,@RequestParam("email") String email)
    {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));
        System.out.println(member.getPassword());
        memberService.join(member);
        return "redirect:/"; // Home 화면으로 다시 In
    }

    @GetMapping("/members")
    public String list(Model model)
    {
        System.out.print("On");
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members); // members 라는 이름으로 model에 넣는 것
        return "members/memberlist";
    }

    @PostMapping("/logintry")
    public String Login(@RequestParam("ID") String name, @RequestParam("password") String password)
    {
        System.out.println(name);
        return "redirect:/";
    }


}
