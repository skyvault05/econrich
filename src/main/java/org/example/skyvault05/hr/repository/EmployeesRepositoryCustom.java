package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.dto.EmpDto;
import org.example.skyvault05.hr.dto.EmpModifyDto;

import java.util.Optional;

public interface EmployeesRepositoryCustom {
    Optional<EmpDto> findDynamicQuery(Long empId, String firstName, String lastName);
    Long multiplyDptSalary(Long dptId, Float multiply);
    Boolean updateWithModifyDto(Long empId, EmpModifyDto dto);
}
