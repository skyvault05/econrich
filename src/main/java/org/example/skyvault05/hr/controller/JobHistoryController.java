package org.example.skyvault05.hr.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.JobHistDto;
import org.example.skyvault05.hr.exception.dto.ExceptionResult;
import org.example.skyvault05.hr.service.JobHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "jobhistory")
@RequiredArgsConstructor
public class JobHistoryController {
    private final JobHistoryService jobHistoryService;

    @Operation(summary = "특정 사원의 이력 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = JobHistDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ExceptionResult.class)))
    })
    @GetMapping("/{empId}")
    public List<JobHistDto> jobHistoryDetails(@PathVariable @Parameter(description = "사원 ID") Long empId){
        return jobHistoryService.findJobHist(empId);
    }
}
