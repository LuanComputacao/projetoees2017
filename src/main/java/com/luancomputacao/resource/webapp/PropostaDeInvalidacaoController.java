package com.luancomputacao.resource.webapp;

import com.luancomputacao.domain.PropostaDeInvalidacao;
import com.luancomputacao.dto.PropostaDeInvalidacaoDAO;
import com.luancomputacao.services.domains.PropostaDeInvalidacaoService;
import com.luancomputacao.services.domains.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/propostas-de-invalidacao/")
public class PropostaDeInvalidacaoController {

    private final String listar = "propostas_de_invalidacao/listar";
    private final String analisar = "propostas_de_invalidacao/analisar";
    private final String criar = "propostas_de_invalidacao/criar";
    private final String visualizar = "propostas_de_invalidacao/visualizar";

    @Autowired
    PropostaDeInvalidacaoService propostaDeInvalidacaoService;

    @Autowired
    private QuestaoService questaoService;

    @GetMapping(value = "")
    public ModelAndView propostasDeInvalidacao() {
        ModelAndView mv = new ModelAndView(this.listar);
        mv.addObject("propostas", propostaDeInvalidacaoService.listar());
        return mv;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERADOR')")
    @GetMapping(value = "{id}/")
    public ModelAndView analisarProposta(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView(this.analisar);
        PropostaDeInvalidacao propostaDeInvalidacao = propostaDeInvalidacaoService.encontrar(id);
        mv.addObject("questao", propostaDeInvalidacao.getQuestao());
        mv.addObject("proposta", propostaDeInvalidacaoService.encontrar(id));
        return mv;
    }

    @GetMapping(value = "criar/{id}")
    public ModelAndView formProposta(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView(this.criar);
        mv.addObject("questao", questaoService.encontrar(id));
        return mv;
    }

    @PostMapping(value = "criar/")
    public ModelAndView criarProposta(@RequestBody PropostaDeInvalidacaoDAO proposta) {
        ModelAndView mv = new ModelAndView(this.visualizar);
        PropostaDeInvalidacao propostaDeInvalidacao = propostaDeInvalidacaoService.criar(proposta);
        mv.addObject("proposta", propostaDeInvalidacao);
        return mv;
    }
}
