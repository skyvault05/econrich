package org.example.skyvault05.hr.domain;

import org.example.skyvault05.hr.repository.CountriesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebMvc
public class CountriesTest {
    @Autowired
    private CountriesRepository countriesRepository;

    @Test
    public void findTest(){
        Countries countries = countriesRepository.findById("AR").orElse(null);
        System.out.println(countries.getCountryId() +":"+ countries.getCountryName() + ":" + countries.getRegions().getRegionName());
    }
}
