package it.sidesoft.corso.restfulapp.repository;

import it.sidesoft.corso.restfulapp.model.Progetto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProgettoRepository extends JpaRepository<Progetto, Long>, ProgettoRepositoryCustom {
}
