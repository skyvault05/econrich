package org.example.skyvault05.hr.service;

import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.DptDto;
import org.example.skyvault05.hr.exception.NoParameterException;
import org.example.skyvault05.hr.repository.DepartmentsRepository;
import org.example.skyvault05.hr.repository.EmployeesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;
    private final EmployeesRepository employeesRepository;

    public DptDto findDepartment(Long dptId, String dptName) {
        if((dptId == null) && (StringUtils.hasText(dptName) || dptName == null)) throw new NoParameterException("유효한 파라미터가 없습니다.");
        return departmentsRepository.findDynamicQuery(dptId, null);
    }

    @Transactional
    public Long salaryRenew(Long dptId, Float multiply) {
        if(dptId == null || multiply == null ||multiply.isNaN()) throw new NoParameterException("유효한 파라미터가 없습니다.");
        return employeesRepository.multiplyDptSalary(dptId, multiply);
    }
}
