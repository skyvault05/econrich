package org.example.skyvault05.globalstatistics;

import lombok.SneakyThrows;
import org.example.skyvault05.globalstatistics.service.GlobalPopulationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class GlobalPopulationTest {
    @Autowired
    private GlobalPopulationRepository globalPopulationRepository;

    @SneakyThrows
    @Test
    public void repositoryTest(){
        String pageNo = "1";
        String numOfRows = "10";
        String countryName = "";
        String countryCode = "JP";

        globalPopulationRepository.findPopulation(pageNo, numOfRows, countryName, countryCode);
    }



}
