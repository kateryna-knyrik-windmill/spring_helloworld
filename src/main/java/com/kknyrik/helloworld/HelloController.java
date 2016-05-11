package com.kknyrik.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Katerina.Knyrik on 5/11/16.
 */
@Controller

@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("helloworld");
        modelAndView.addObject("message", "Hello World");
        return modelAndView;
    }
}
