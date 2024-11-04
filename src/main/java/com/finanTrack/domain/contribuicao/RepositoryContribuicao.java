package com.finanTrack.domain.contribuicao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryContribuicao extends JpaRepository<Contribuicao, Integer> {
}
