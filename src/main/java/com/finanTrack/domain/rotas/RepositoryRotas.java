package com.finanTrack.domain.rotas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRotas extends JpaRepository<Rotas, Integer> {
}
