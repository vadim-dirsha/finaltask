package ru.vadimdirsha.java.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping( "/" )
public class MainController {

    public static Logger logger = LogManager.getLogger("ControllerLogger");

    @RequestMapping(method=GET)
    public String home(Model model) {
        return "home";
    }

    @RequestMapping(value="professor", method=GET)
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value="/student", method=GET)
    public String student(Model model) {
        return "student";
    }

}
