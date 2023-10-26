package it.sidesoft.corso.restfulapp.mapper;

import it.sidesoft.corso.restfulapp.dto.PersonaDto;
import it.sidesoft.corso.restfulapp.dto.ProgettoDto;
import it.sidesoft.corso.restfulapp.model.Persona;
import it.sidesoft.corso.restfulapp.model.Progetto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-26T08:52:46+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class ProgettoDtoMapperImpl implements ProgettoDtoMapper {

    @Override
    public ProgettoDto toDto(Progetto entity) {
        if ( entity == null ) {
            return null;
        }

        ProgettoDto progettoDto = new ProgettoDto();

        progettoDto.setId( entity.getId() );
        progettoDto.setTitolo( entity.getTitolo() );
        progettoDto.setDescrizione( entity.getDescrizione() );
        progettoDto.setPersone( personaListToPersonaDtoList( entity.getPersone() ) );

        return progettoDto;
    }

    @Override
    public List<ProgettoDto> toDto(List<Progetto> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ProgettoDto> list = new ArrayList<ProgettoDto>( entity.size() );
        for ( Progetto progetto : entity ) {
            list.add( toDto( progetto ) );
        }

        return list;
    }

    @Override
    public Progetto toEntity(ProgettoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Progetto progetto = new Progetto();

        progetto.setTitolo( dto.getTitolo() );
        progetto.setDescrizione( dto.getDescrizione() );
        progetto.setPersone( personaDtoListToPersonaList( dto.getPersone() ) );

        return progetto;
    }

    @Override
    public PersonaDto toDto(Persona entity) {
        if ( entity == null ) {
            return null;
        }

        PersonaDto personaDto = new PersonaDto();

        personaDto.setId( entity.getId() );
        personaDto.setNome( entity.getNome() );
        personaDto.setCognome( entity.getCognome() );

        return personaDto;
    }

    protected List<PersonaDto> personaListToPersonaDtoList(List<Persona> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonaDto> list1 = new ArrayList<PersonaDto>( list.size() );
        for ( Persona persona : list ) {
            list1.add( toDto( persona ) );
        }

        return list1;
    }

    protected Persona personaDtoToPersona(PersonaDto personaDto) {
        if ( personaDto == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setId( personaDto.getId() );
        persona.setNome( personaDto.getNome() );
        persona.setCognome( personaDto.getCognome() );
        persona.setProgetto( toEntity( personaDto.getProgetto() ) );

        return persona;
    }

    protected List<Persona> personaDtoListToPersonaList(List<PersonaDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Persona> list1 = new ArrayList<Persona>( list.size() );
        for ( PersonaDto personaDto : list ) {
            list1.add( personaDtoToPersona( personaDto ) );
        }

        return list1;
    }
}
