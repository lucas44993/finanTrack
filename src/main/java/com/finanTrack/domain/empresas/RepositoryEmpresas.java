package com.finanTrack.domain.empresas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmpresas extends JpaRepository<Empresas, Integer> {
}
