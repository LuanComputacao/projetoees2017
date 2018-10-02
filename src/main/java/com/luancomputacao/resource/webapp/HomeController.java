package com.luancomputacao.resource.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final String home = "index";

    @GetMapping(value = "/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView(this.home);
        mv.addObject("professor", true);
        mv.addObject("moderador", true);
        return mv;
    }
}
