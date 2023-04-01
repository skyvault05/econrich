package org.example.skyvault05.hr.service;

import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.EmpDto;
import org.example.skyvault05.hr.dto.EmpModifyDto;
import org.example.skyvault05.hr.exception.NoParameterException;
import org.example.skyvault05.hr.exception.NoResultException;
import org.example.skyvault05.hr.repository.EmployeesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    public EmpDto findEmp(Long empId, String firstName, String lastName) {
        if((empId == null)
                &&(firstName == null || "".equals(firstName))
                &&(lastName == null || "".equals(lastName))) throw new NoParameterException("유효한 파라미터가 없습니다.");
        return employeesRepository.findDynamicQuery(empId, firstName, lastName).orElseThrow(() -> new NoResultException("해당 사원을 찾을 수 없습니다."));
    }

    @Transactional
    public EmpDto modifyEmp(Long empId, EmpModifyDto dto){
        employeesRepository.updateWithModifyDto(empId, dto);
        EmpDto newDto = employeesRepository.findDynamicQuery(empId, null, null).orElseThrow(() -> new NoResultException("해당 사원을 찾을 수 없습니다."));


        return newDto;
    }
}
