package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.dto.DptDto;

public interface DepartmentsRepositoryCustom {
    DptDto findDynamicQuery(Long dptId, String dptName);
}
