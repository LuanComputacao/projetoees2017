package com.luancomputacao.resource.webapp;

import com.luancomputacao.domain.enums.Perfil;
import com.luancomputacao.security.UserSpringSecurity;
import com.luancomputacao.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final String home = "index";

    @GetMapping(value = "/")
    public ModelAndView home() {

        UserSpringSecurity userSS = UserService.autenticated();

        ModelAndView mv = new ModelAndView(this.home);
        mv.addObject("professor", userSS.hasRole(Perfil.PROFESSOR));
        mv.addObject("moderador", userSS.hasRole(Perfil.MODERADOR));
        return mv;
    }
}
