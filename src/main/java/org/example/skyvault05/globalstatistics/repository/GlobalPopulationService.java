package org.example.skyvault05.globalstatistics.repository;

import lombok.RequiredArgsConstructor;
import org.example.skyvault05.globalstatistics.service.GlobalPopulationRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GlobalPopulationService {
    private final GlobalPopulationRepository globalPopulationRepository;

    public String findGlobalPopulation(String pageNo, String numOfRows, String countryName, String countryCode) throws IOException {
        return globalPopulationRepository.findPopulation(pageNo, numOfRows, countryName, countryCode);
    }
}
