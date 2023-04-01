package org.example.skyvault05.globalstatistics.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.globalstatistics.repository.GlobalPopulationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("globalpopulation")
@RequiredArgsConstructor
public class GlobalPopulationController {
    private final GlobalPopulationService globalPopulationService;

    @Operation(summary = "국가별 인구 증감 정보 조회.")
    @GetMapping("/{pageNo}/{numOfRows}/{countryName}/{countryCode}")
    public String globalPopulationDetails(@PathVariable @Parameter(description = "페이지 번호", example = "1") String pageNo,
                                          @PathVariable @Parameter(description = "한 페이지 결과 수", example = "10") String numOfRows,
                                          @PathVariable @Parameter(description = "국가명", example = "가나") String countryName,
                                          @PathVariable @Parameter(description = "국가코드", example = "GH") String countryCode) throws IOException {
        return globalPopulationService.findGlobalPopulation(pageNo, numOfRows, countryName, countryCode);
    }

}
