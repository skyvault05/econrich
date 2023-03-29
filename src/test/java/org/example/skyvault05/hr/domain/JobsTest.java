package org.example.skyvault05.hr.domain;

import org.example.skyvault05.hr.repository.JobsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class JobsTest {
    @Autowired
    private JobsRepository jobsRepository;

    @Test
    public void findTest(){
        Jobs jobs = jobsRepository.findById("AC_ACCOUNT").orElse(null);
        System.out.println(jobs);
    }
}
