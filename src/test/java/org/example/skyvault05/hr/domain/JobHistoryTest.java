package org.example.skyvault05.hr.domain;

import lombok.SneakyThrows;
import org.example.skyvault05.hr.dto.JobHistDto;
import org.example.skyvault05.hr.repository.EmployeesRepository;
import org.example.skyvault05.hr.repository.JobHistoryRepository;
import org.example.skyvault05.hr.service.JobHistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class JobHistoryTest {
    @Autowired
    private JobHistoryRepository jobHistoryRepository;
    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private JobHistoryService jobHistoryService;

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

    @Test
    public void dynamicQueryTest(){
        Long empid = 101L;
        String dateStr = "1989-09-21";
        LocalDate startDate = LocalDate.parse(dateStr);
        List<JobHistDto> list = jobHistoryRepository.findDynamicQuery(empid, null);
        for(JobHistDto jobHistDto : list){
            System.out.println(jobHistDto);
        }
    }

    @Test
    public void serviceFindJobHist(){
        List<JobHistDto> list = jobHistoryService.findJobHist(101L);
        for(JobHistDto jobHistDto : list){
            System.out.println(jobHistDto);
        }
    }
}
