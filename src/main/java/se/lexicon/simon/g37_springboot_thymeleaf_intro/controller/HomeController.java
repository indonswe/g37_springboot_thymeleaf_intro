package se.lexicon.simon.g37_springboot_thymeleaf_intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    //http://localhost:8080/
    //http://localhost:8080/?message=Custom+Massage+From+Path
    @GetMapping({"/", "/home"})
    public String home(
          @RequestParam(name = "message", defaultValue = "HELLO FROM THE INSIDE OF HOMECONTROLLER" )  String message,
            Model model){

        model.addAttribute("message",message);
        model.addAttribute("hello", "hello this is another attribute");


        return "home";
    }

    //http://localhost:8080/secondpage
    //Alternative to GetMapping
    @RequestMapping(value = "/secondpage", method = RequestMethod.GET)
    public String otherPage(){
        return "second";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }











}
