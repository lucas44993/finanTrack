package com.finanTrack.domain.fabricas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFabricas extends JpaRepository<Fabricas,Integer> {
}
