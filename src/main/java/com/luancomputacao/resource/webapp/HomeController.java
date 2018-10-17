package com.luancomputacao.resource.webapp;

import com.luancomputacao.security.UserSS;
import com.luancomputacao.services.domains.ProfessorService;
import com.luancomputacao.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final String home = "index";

    @Autowired
    ProfessorService professorService;

    @GetMapping(value = "/")
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView(this.home);

        UserSS userSS = professorService.obterUserSS(UserService.authenticated());
        mv.addObject("professor", professorService.eProfessor(userSS));
        mv.addObject("moderador", professorService.eModerador(userSS));
        return mv;
    }
}
