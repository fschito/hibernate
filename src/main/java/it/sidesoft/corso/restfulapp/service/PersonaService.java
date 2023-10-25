package it.sidesoft.corso.restfulapp.service;


import it.sidesoft.corso.restfulapp.dto.PersonaDto;
import it.sidesoft.corso.restfulapp.mapper.PersonaDtoMapper;
import it.sidesoft.corso.restfulapp.model.Persona;
import it.sidesoft.corso.restfulapp.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaDtoMapper personaDtoMapper;

    public List<PersonaDto> findAll() {
        log.info("Recupero tutte le persone");
        List<Persona> personaList = personaRepository.findAll();
        List<PersonaDto> personaDtolist = personaDtoMapper.toDto(personaList);
        return personaDtolist;
    }


    public PersonaDto save(PersonaDto dto) {
        log.info(String.format("Salvo persona: %s", dto.toString()));
        Persona entity = personaDtoMapper.toEntity(dto);
        entity = personaRepository.save(entity);
        return personaDtoMapper.toDto(entity);
    }

    public Optional<PersonaDto> findById(Long id) {
        log.info(String.format("Recupero persona con id:%s", id));
        Optional<Persona> persona = personaRepository.findById(id);
        if (persona.isPresent()) {
            PersonaDto dto1 = personaDtoMapper.toDto(persona.get());
            return Optional.of(dto1);
        }
        return Optional.empty();
    }

    public List<PersonaDto> findByNome(String nome) {
        List<Persona> personaList = personaRepository.findByNome(nome);
        List<PersonaDto> personaDtolist = personaDtoMapper.toDto(personaList);
        return personaDtolist;
    }

    public List<PersonaDto> findByCognomeContainingIgnoreCase(String cognome) {
        List<Persona> personaList = personaRepository.findByCognomeContainingIgnoreCase(cognome);
        List<PersonaDto> personaDtolist = personaDtoMapper.toDto(personaList);
        return personaDtolist;
    }
}
