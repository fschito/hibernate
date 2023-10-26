package it.sidesoft.corso.restfulapp.repository;

import it.sidesoft.corso.restfulapp.model.Progetto;

import java.util.List;

public interface ProgettoRepositoryCustom {

    List<Progetto> ricercaProgetti(String titolo, Integer offset, Integer limit);
}
