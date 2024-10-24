package com.finanTrack.domain.metas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryMetas extends JpaRepository<Metas, Integer> {
}
