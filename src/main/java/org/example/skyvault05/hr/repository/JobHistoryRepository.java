package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.domain.JobHistory;
import org.example.skyvault05.hr.domain.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId>, JobHistoryRepositoryCustom {
}
