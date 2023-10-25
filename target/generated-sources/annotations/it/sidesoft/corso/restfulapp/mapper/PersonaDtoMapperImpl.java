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
    date = "2023-10-23T19:16:45+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class PersonaDtoMapperImpl implements PersonaDtoMapper {

    @Override
    public PersonaDto toDto(Persona entity) {
        if ( entity == null ) {
            return null;
        }

        PersonaDto personaDto = new PersonaDto();

        personaDto.setId( entity.getId() );
        personaDto.setNome( entity.getNome() );
        personaDto.setCognome( entity.getCognome() );
        personaDto.setProgetto( toDto( entity.getProgetto() ) );

        return personaDto;
    }

    @Override
    public List<PersonaDto> toDto(List<Persona> entity) {
        if ( entity == null ) {
            return null;
        }

        List<PersonaDto> list = new ArrayList<PersonaDto>( entity.size() );
        for ( Persona persona : entity ) {
            list.add( toDto( persona ) );
        }

        return list;
    }

    @Override
    public ProgettoDto toDto(Progetto entity) {
        if ( entity == null ) {
            return null;
        }

        ProgettoDto progettoDto = new ProgettoDto();

        progettoDto.setId( entity.getId() );
        progettoDto.setTitolo( entity.getTitolo() );
        progettoDto.setDescrizione( entity.getDescrizione() );

        return progettoDto;
    }

    @Override
    public Persona toEntity(PersonaDto dto) {
        if ( dto == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setNome( dto.getNome() );
        persona.setCognome( dto.getCognome() );
        persona.setProgetto( progettoDtoToProgetto( dto.getProgetto() ) );

        return persona;
    }

    protected List<Persona> personaDtoListToPersonaList(List<PersonaDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Persona> list1 = new ArrayList<Persona>( list.size() );
        for ( PersonaDto personaDto : list ) {
            list1.add( toEntity( personaDto ) );
        }

        return list1;
    }

    protected Progetto progettoDtoToProgetto(ProgettoDto progettoDto) {
        if ( progettoDto == null ) {
            return null;
        }

        Progetto progetto = new Progetto();

        progetto.setId( progettoDto.getId() );
        progetto.setTitolo( progettoDto.getTitolo() );
        progetto.setDescrizione( progettoDto.getDescrizione() );
        progetto.setPersone( personaDtoListToPersonaList( progettoDto.getPersone() ) );

        return progetto;
    }
}
