package it.sidesoft.corso.restfulapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.sidesoft.corso.restfulapp.dto.PersonaDto;
import it.sidesoft.corso.restfulapp.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    @Operation(description = "Restituisce tutte le persone")
    @GetMapping("/persone")
    public List<PersonaDto> recuperaTutti() {
        return personaService.findAll();
    }

    @Operation(description = "Salva una persona")
    @PostMapping("/persone")
    PersonaDto nuovaPersona(@RequestBody PersonaDto persona) {
        return personaService.save(persona);
    }

    @GetMapping("/persone/{id}")
    PersonaDto recuperaPersona(@PathVariable Long id) {
        return personaService.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Impossibile trovare la persona con id:%s", id)));
    }

    @GetMapping("/persone/nome/{nome}")
    public List<PersonaDto> recuperaPersonaDaNome(@PathVariable String nome) {
        return personaService.findByNome(nome);
    }

    @GetMapping("/persone/cognome/{cognome}")
    public List<PersonaDto> recuperaPersonaDaCognome(@PathVariable String cognome) {
        return personaService.findByCognomeContainingIgnoreCase(cognome);
    }
}
