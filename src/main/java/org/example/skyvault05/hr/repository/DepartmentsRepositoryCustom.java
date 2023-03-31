package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.dto.DptInfo;

import java.util.List;

public interface DepartmentsRepositoryCustom {
    DptInfo findDynamicQuery(Long dptId, String dptName);
}
