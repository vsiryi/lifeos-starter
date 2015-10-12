package com.willbe.lifeos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Creation date: 10/9/15
 *
 * @author Vitalii Siryi
 */
@Controller
public class SomeMvcController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(ModelMap model) {
        return "main";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String forbidden(ModelMap model) {
        return "error";
    }

}
