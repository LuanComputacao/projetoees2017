package com.luancomputacao.resource.webapp;

import com.luancomputacao.domain.PropostaDeInvalidacao;
import com.luancomputacao.services.PropostaDeInvalidacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/propostas-de-invalidacao/")
public class PropostaDeInvalidacaoController {

    private final String propostasDeInvalidacao = "propostas_de_invalidacao/listar";
    private final String analisarProposta = "propostas_de_invalidacao/analisar";
    private final String criarProposta = "propostas_de_invalidacao/criar";

    @Autowired
    PropostaDeInvalidacaoService propostaDeInvalidacaoService;

    @GetMapping(value = "")
    public ModelAndView propostasDeInvalidacao() {
        ModelAndView mv = new ModelAndView(this.propostasDeInvalidacao);
        mv.addObject("propostas", propostaDeInvalidacaoService.listar());
        return mv;
    }

    @GetMapping(value = "{id}/")
    public ModelAndView analisarProposta(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView(this.analisarProposta);
        PropostaDeInvalidacao propostaDeInvalidacao = propostaDeInvalidacaoService.encontrar(id);
        mv.addObject("questao", propostaDeInvalidacao.getQuestao());
        mv.addObject("proposta", propostaDeInvalidacaoService.encontrar(id));
        return mv;
    }

    @GetMapping(value = "criar/")
    public ModelAndView criarProposta() {
        ModelAndView mv = new ModelAndView(this.criarProposta);
        return mv;
    }
}
