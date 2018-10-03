package com.luancomputacao.resource.webapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.luancomputacao.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/questoes/")
public class QuestoesController {

    private final String view = "questoes";

    @Autowired
    private QuestaoService questaoService;

    @GetMapping(value = "/")
    public ModelAndView questoes(){
        ModelAndView mv = new ModelAndView(this.view);
        mv.addObject("questoes", questaoService.listar());

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        mv.addObject("jsonteste", gson.toJson(questaoService.listar()));
        return mv;
    }

}
