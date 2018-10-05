package com.luancomputacao.resource.webapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luancomputacao.domain.Disciplina;
import com.luancomputacao.domain.Materia;
import com.luancomputacao.domain.Questao;
import com.luancomputacao.services.DisciplinaService;
import com.luancomputacao.services.MateriaService;
import com.luancomputacao.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/questoes")
public class QuestoesController {

    private final String view = "questoes";

    @Autowired
    private QuestaoService questaoService;

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private MateriaService materiaService;

    @GetMapping(value = {"/", ""})
    public ModelAndView questoes() throws JsonProcessingException {
        ModelAndView mv = new ModelAndView(this.view);
        ObjectMapper objectMapper = new ObjectMapper();

        List<Disciplina> disciplinas = disciplinaService.listar();
        mv.addObject("disciplinas", objectMapper.writeValueAsString(disciplinas));


        List<Materia> materias = materiaService.listar();
        mv.addObject("materias", objectMapper.writeValueAsString(materias));

        List<Questao> questoes = questaoService.listar();
        mv.addObject("questoes", objectMapper.writeValueAsString(questoes));

        return mv;
    }

}
