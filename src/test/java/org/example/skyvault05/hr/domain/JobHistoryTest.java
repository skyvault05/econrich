package org.example.skyvault05.hr.domain;

import lombok.SneakyThrows;
import org.example.skyvault05.hr.repository.EmployeesRepository;
import org.example.skyvault05.hr.repository.JobHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class JobHistoryTest {
    @Autowired
    private JobHistoryRepository jobHistoryRepository;
    @Autowired
    private EmployeesRepository employeesRepository;

    @SneakyThrows
    @Test
    public void findTest(){
        LocalDate dateTime = LocalDate.parse("1989-09-21", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Employees employees = employeesRepository.findById(101L).orElse(null);
        JobHistoryId jobHistoryId = new JobHistoryId(employees, dateTime);
        JobHistory jobHistory = jobHistoryRepository.findById(jobHistoryId).orElse(null);

        System.out.println(jobHistoryId.getEmployees());
        System.out.println(jobHistoryId.getStartDate());
        System.out.println(jobHistory);
    }
}
