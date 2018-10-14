package com.luancomputacao.resource.webapp;

import com.luancomputacao.domain.enums.Perfil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private String formLogin = "index";


    @GetMapping("/login")
    public ModelAndView formLogin() {
        ModelAndView mv = new ModelAndView(formLogin);
        return mv;
    }
}
