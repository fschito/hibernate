package it.sidesoft.corso.restfulapp.controller;

import it.sidesoft.corso.restfulapp.dto.PersonaDto;
import it.sidesoft.corso.restfulapp.dto.ProgettoDto;
import it.sidesoft.corso.restfulapp.service.PersonaService;
import it.sidesoft.corso.restfulapp.service.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/progetti")
public class ProgettoController {

    @Autowired
    private ProgettoService progettoService;

    @GetMapping
    public List<ProgettoDto> recuperaTutti() {
        return progettoService.findAll();
    }

    @PostMapping
    ProgettoDto nuovoProgetto(@RequestBody ProgettoDto persona) {
        return progettoService.save(persona);
    }

    @GetMapping("/{id}")
    ProgettoDto recuperaProgetto(@PathVariable Long id) {
        return progettoService.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Impossibile trovare il progetto con id:%s", id)));
    }

    @GetMapping("/ricercaProgetti")
    List<ProgettoDto> ricercaProgetti(@RequestParam(value = "titolo") String titolo,
                                @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return progettoService.ricercaProgetti(titolo,offset, limit);
    }
}
