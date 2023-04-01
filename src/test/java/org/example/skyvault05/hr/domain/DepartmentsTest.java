package org.example.skyvault05.hr.domain;

import org.example.skyvault05.hr.dto.DptDto;
import org.example.skyvault05.hr.repository.DepartmentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DepartmentsTest {
    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Test
    public void findTest(){
        Departments departments = departmentsRepository.findById(100L).orElse(null);
        System.out.println(departments);
    }

    @Test
    public void dynamicQueryTest(){
        DptDto dptDto = departmentsRepository.findDynamicQuery(60L, null);
            System.out.println(dptDto);
    }
}
