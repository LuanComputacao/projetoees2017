package com.luancomputacao.resource.webapp;

import com.luancomputacao.domain.enums.Perfil;
import com.luancomputacao.security.UserSS;
import com.luancomputacao.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final String home = "index";

    @GetMapping(value = "/")
    public ModelAndView home() {

        boolean professor = false;
        boolean moderador = false;

        UserSS userSS = UserService.authenticated();

        System.out.println("home");
        System.out.println(userSS);
        if (userSS != null) {
            professor = userSS.hasRole(Perfil.PROFESSOR);
            moderador = userSS.hasRole(Perfil.MODERADOR);
        }

        ModelAndView mv = new ModelAndView(this.home);
        mv.addObject("professor", professor);
        mv.addObject("moderador", moderador);
        return mv;
    }
}
