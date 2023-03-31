package org.example.skyvault05.hr.service;

import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.EmpInfo;
import org.example.skyvault05.hr.exception.NoParameterException;
import org.example.skyvault05.hr.exception.NoResultException;
import org.example.skyvault05.hr.repository.EmployeesRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    public EmpInfo findEmp(Long empId, String firstName, String lastName) {
        if((empId == null)
                &&("".equals(firstName) || firstName == null)
                &&("".equals(lastName) || lastName == null)) throw new NoParameterException();
        return employeesRepository.findDynamicQuery(empId, firstName, lastName).orElseThrow(() -> new NoResultException());
    }
}
