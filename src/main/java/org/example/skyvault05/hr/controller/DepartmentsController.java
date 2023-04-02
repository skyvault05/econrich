package org.example.skyvault05.hr.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.DptDto;
import org.example.skyvault05.hr.exception.dto.ExceptionResult;
import org.example.skyvault05.hr.service.DepartmentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "departments")
@RequiredArgsConstructor
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    @Operation(summary = "부서 정보.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = DptDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ExceptionResult.class)))
    })
    @GetMapping("/{dptId}")
    public DptDto departmentDetails(@PathVariable @Parameter(description = "부서 Id") Long dptId){
        return departmentsService.findDepartment(dptId, null);
    }

    @Operation(summary = "부서 월급 일괄 인상.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Long.class), schemaProperties = @SchemaProperty(name = "적용된 횟수.", schema = @Schema(type = "Long")))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ExceptionResult.class)))
    })
    @PatchMapping("/{dptId}/salary-change/{multiply}")
    public Long salaryRenew(@PathVariable @Parameter(description = "부서 ID") Long dptId,
                            @PathVariable @Parameter(description = "임금 변동 비율(임금 X 비율) 1.1이면 10%인상.", example = "1.1") Float multiply){
        return departmentsService.salaryRenew(dptId, multiply);
    }
}
