package com.lisnenko.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(Model model,
                            @RequestParam(value = "name" , required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname){

        model.addAttribute("message", "hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculate(Model model,
                            @RequestParam int numberOne,
                            @RequestParam int numberTwo,
                            @RequestParam String action){

        double result = 0;
        switch (action){
            case ("/+") :
                result = numberOne + numberTwo;
                break;
            case ("-") :
                result = numberOne - numberTwo;
                break;
            case ("*") :
                result = numberOne * numberTwo;
                break;
            case ("/") :
                result = numberOne / (double) numberTwo;
                break;
        }
        model.addAttribute("result", result);

        return "first/result";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
