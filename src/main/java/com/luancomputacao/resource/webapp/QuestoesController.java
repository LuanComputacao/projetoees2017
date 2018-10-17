package com.luancomputacao.resource.webapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luancomputacao.domain.Questao;
import com.luancomputacao.security.UserSS;
import com.luancomputacao.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/questoes")
public class QuestoesController {

    private final String view = "questoes/lista";
    private final String criarQuestao = "questoes/criar";
    private final String editarQuestao = "questoes/editar";
    private final String questao = "questoes/visualizar";

    @Autowired
    private QuestaoService questaoService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private MateriaService materiaService;

    @Autowired
    private FaseDeEnsinoService faseDeEnsinoService;

    @GetMapping(value = {"/", ""})
    public ModelAndView questoes() throws JsonProcessingException {
        ModelAndView mv = new ModelAndView(this.view);
        ObjectMapper objectMapper = new ObjectMapper();

        UserSS userSS = professorService.obterUserSS(UserService.authenticated());
        mv.addObject("professor", professorService.eProfessor(userSS));
        mv.addObject("moderador", professorService.eModerador(userSS));

        List<Questao> questoes = questaoService.listar();
        mv.addObject("questoes", questoes);
        mv.addObject("questoesJSON", objectMapper.writeValueAsString(questoes));

        return mv;
    }

    @GetMapping(value = "editar/{id}/")
    public ModelAndView editarQuestao(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView(this.editarQuestao);

        mv.addObject("disciplinas",  disciplinaService.listar());

        mv.addObject("materias",  materiaService.listar());

        mv.addObject("questao", questaoService.encontrar(id));
        return mv;
    }


    @GetMapping(value = "criar/")
    public ModelAndView criarQuestao() {
        ModelAndView mv = new ModelAndView(this.criarQuestao);
        mv.addObject("disciplinas",  disciplinaService.listar());
        mv.addObject("materias",  materiaService.listar());
        mv.addObject("fasesDeEnsino",  faseDeEnsinoService.listar());
        return mv;
    }

    @GetMapping(value = "{id}/")
    public ModelAndView visualizarQuestao(@PathVariable Integer id) throws JsonProcessingException {
        ModelAndView mv = new ModelAndView(this.questao);
        ObjectMapper objectMapper = new ObjectMapper();
        Questao questao = questaoService.encontrar(id);
        mv.addObject("questao", questao);
        return mv;
    }
}
