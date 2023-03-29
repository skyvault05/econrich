package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.domain.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, String> {
}
