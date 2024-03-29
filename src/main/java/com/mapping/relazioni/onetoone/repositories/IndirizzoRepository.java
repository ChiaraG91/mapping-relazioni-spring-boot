package com.mapping.relazioni.onetoone.repositories;

import com.mapping.relazioni.onetoone.entities.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepository extends JpaRepository<Indirizzo,Long> {


}
