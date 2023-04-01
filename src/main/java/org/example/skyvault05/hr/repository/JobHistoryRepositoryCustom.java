package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.dto.JobHistDto;

import java.time.LocalDate;
import java.util.List;

public interface JobHistoryRepositoryCustom {
    List<JobHistDto> findDynamicQuery(Long empId, LocalDate startDate);
}
