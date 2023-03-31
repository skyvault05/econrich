package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.dto.EmpInfo;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepositoryCustom {
    Optional<EmpInfo> findDynamicQuery(Long empId, String firstName, String lastName);
}
