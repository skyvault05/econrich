package org.example.skyvault05.hr.domain;

import org.example.skyvault05.hr.repository.LocationsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LocationsTest {
    @Autowired
    private LocationsRepository locationsRepository;

    @Test
    public void findTest(){
        Locations locations = locationsRepository.findById(1000L).orElse(null);
        System.out.println(locations);
    }
}
