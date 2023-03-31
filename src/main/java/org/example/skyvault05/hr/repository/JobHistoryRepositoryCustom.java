package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.dto.JobHistInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface JobHistoryRepositoryCustom {
    List<JobHistInfo> findDynamicQuery(Long empId, LocalDate startDate);
}
