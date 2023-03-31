package org.example.skyvault05.hr.domain;

import org.example.skyvault05.hr.dto.EmpInfo;
import org.example.skyvault05.hr.exception.NoResultException;
import org.example.skyvault05.hr.repository.EmployeesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeesTest {
    @Autowired
    private EmployeesRepository employeesRepository;

    @Test
    public void findTest(){
        Employees employees = employeesRepository.findById(104L).orElse(null);
        System.out.println(employees);
    }

    @Test
    public void dynamicQueryTest(){
        EmpInfo empInfo = employeesRepository.findDynamicQuery(10L, null, null).orElseThrow(() -> new NoResultException());
        System.out.println(empInfo);
    }
}
