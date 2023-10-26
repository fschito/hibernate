package it.sidesoft.corso.restfulapp.repository;

import it.sidesoft.corso.restfulapp.model.Progetto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ProgettoRepositoryImpl  implements  ProgettoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Progetto> ricercaProgetti(String titolo, Integer offset, Integer limit) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Progetto> cq = cb.createQuery(Progetto.class);
        Root<Progetto> progetto = cq.from(Progetto.class);
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(titolo)) {
            predicates.add(cb.like(progetto.get("titolo"), addWildcard(titolo)));
        }

        cq.where((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
        cq.orderBy(cb.desc(progetto.get("titolo")));
        TypedQuery<Progetto> query = em.createQuery(cq);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();

    }

    public static String addLeftWildcart(String s) {return "%" + s;}

    public static String addRightWildcart(String s) {return s + "%";}

    public static String addWildcard(String s) {return addLeftWildcart(addRightWildcart(s));}

}
