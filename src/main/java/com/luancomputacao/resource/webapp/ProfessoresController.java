package com.luancomputacao.resource.webapp;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfessoresController {

    private final String listaProfessores = "partials/professor/professores";
    private final String visualizaProfessor = "partials/professor/visualiza-professor";
    private final String formProfessor = "partials/professor/form-professor";


    @Autowired
    ProfessorService professorService;

    @GetMapping(value = "/professores")
    public ModelAndView professores() {
        ModelAndView mv = new ModelAndView(listaProfessores);
        mv.addObject("professores", professorService.listar());
        return mv;
    }

    @GetMapping(value = "/professor")
    public ModelAndView formProfessor() {
        ModelAndView mv = new ModelAndView(formProfessor);
        return mv;
    }

    @PostMapping(value = "/professor")
    public ModelAndView criaProfessor() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @GetMapping(value = "/professor/{id}")
    public ModelAndView professor(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView(visualizaProfessor);
        mv.addObject("professor", professorService.encontrar(id));
        return mv;
    }

}
