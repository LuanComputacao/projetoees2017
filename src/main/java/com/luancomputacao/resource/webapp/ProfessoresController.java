package com.luancomputacao.resource.webapp;

import com.luancomputacao.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/professores")
public class ProfessoresController {

    private final String view = "professores";

    @Autowired
    ProfessorService professorService;

    @GetMapping
    public ModelAndView professores() {
        ModelAndView mv = new ModelAndView(view);
        mv.addObject("professores", professorService.listar());
        return mv;
    }
}
