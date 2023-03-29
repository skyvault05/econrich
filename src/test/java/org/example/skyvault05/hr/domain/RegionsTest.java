package org.example.skyvault05.hr.domain;

import org.example.skyvault05.hr.domain.Regions;
import org.example.skyvault05.hr.repository.RegionsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RegionsTest {
    @Autowired
    private RegionsRepository regionsRepository;

    @Test
    public void findTest(){
        Regions regions = regionsRepository.findById(1L).orElse(null);
        System.out.println(regions.getRegionName()+":"+regions.getRegionId());
    }
}
