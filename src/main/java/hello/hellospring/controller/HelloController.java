package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //host 8080 /hello하면 밑에 부분이 나온다
    public String hello(Model model){
        model.addAttribute("data","hello!!"); //data가 key이고, value가 hello!!이다.
        return "hello"; //hello가 반환되면, templates에서 hello를 찾아서 띄운다.

    }
}
