package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.domain.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionsRepository extends JpaRepository<Regions, Integer> {
}
