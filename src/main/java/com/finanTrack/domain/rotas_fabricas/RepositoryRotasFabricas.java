package com.finanTrack.domain.rotas_fabricas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRotasFabricas extends JpaRepository<RotasFabricas, Integer> {
}
