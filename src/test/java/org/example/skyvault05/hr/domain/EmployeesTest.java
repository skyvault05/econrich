package org.example.skyvault05.hr.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.example.skyvault05.hr.dto.EmpDto;
import org.example.skyvault05.hr.dto.EmpModifyDto;
import org.example.skyvault05.hr.dto.EmpSaveDto;
import org.example.skyvault05.hr.exception.NoResultException;
import org.example.skyvault05.hr.mapper.EmployeesMapper;
import org.example.skyvault05.hr.repository.EmployeesRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeesTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private EmployeesMapper employeesMapper;

    @Test
    @Disabled
    public void saveNewEmp(){
        EmpSaveDto dto = new EmpSaveDto(
                301L,
                "Jack",
                "Daniel",
                "DANIEL",
                "123.456.789",
                LocalDateTime.parse("2022-03-02T00:00:00"),
                "SH_CLERK",
                BigDecimal.valueOf(15000L),
                BigDecimal.valueOf(0.10f),
                100L,
                110L
        );
        employeesRepository.save(employeesMapper.DtoToEntity(dto));
    }
    @Test
    public void findTest(){
        Employees employees = employeesRepository.findById(104L).orElse(null);
        System.out.println(employees);
    }

    @Test
    public void dynamicQueryTest(){
        EmpDto empDto = employeesRepository.findDynamicQuery(101L, null, null).orElseThrow(() -> new NoResultException());
        System.out.println(empDto);
    }

    @Test
    @Transactional
    @Disabled
    public void multiplyDptSalaryTest(){
        Float multi = 1.02f;
        Long dptId = 110L;

        employeesRepository.multiplyDptSalary(dptId, multi);
    }

    @SneakyThrows
    @Test
    @Transactional
    @Disabled
    public void multiplyDptSalaryResultTest(){
        Float multi = 1.02f;
        Long dptId = 110L;

        mvc.perform(patch("/departments/110/salary-change/1.05"))
                .andExpect(status().isOk());
    }

    @SneakyThrows
    @Test
    @Disabled
    public void modifyEmpTest(){
        ObjectMapper objectMapper = new ObjectMapper();

        EmpModifyDto dto = new EmpModifyDto(
                "Jack",
                "Daniel",
                "DANIEL",
                "123.456.789",
                LocalDateTime.parse("2022-03-02T00:00:00"),
                "SH_CLERK",
                BigDecimal.valueOf(15000L),
                BigDecimal.valueOf(0.10),
                100L,
                110L
        );

//        EmpModifyDto dto = new EmpModifyDto(
//                "modifiedFirstName",
//                "modifiedLastName",
//                "MODIFIEDEMAIL",
//                "987.654.321",
//                LocalDateTime.parse("2002-03-02T10:15:30"),
//                "SA_REP",
//                BigDecimal.valueOf(20000L),
//                BigDecimal.valueOf(0.20),
//                101L,
//                80L
//        );

        String json = objectMapper.registerModule(new JavaTimeModule()).writeValueAsString(dto);

        System.out.println(json);




        mvc.perform(
                put("/employees/301")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andDo(print());
    }
}
