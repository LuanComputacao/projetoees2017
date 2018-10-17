package com.luancomputacao.resource.rest;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.dto.ProfessorDTO;
import com.luancomputacao.services.domains.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest/professores")
public class ProfessorResource {

    @Autowired
    ProfessorService professorService;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Professor> professores = professorService.listar();
        List<ProfessorDTO> professorDTOs = professores.stream().map(ProfessorDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(professorDTOs);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> encontrar(@PathVariable Integer id) {
        return ResponseEntity.ok().body(professorService.encontrar(id));
    }
}
