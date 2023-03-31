package org.example.skyvault05.hr.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.DptInfo;
import org.example.skyvault05.hr.dto.EmpInfo;
import org.example.skyvault05.hr.exception.dto.ExceptionResult;
import org.example.skyvault05.hr.service.DepartmentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "departments")
@RequiredArgsConstructor
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    @Operation(description = "부서 정보.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = DptInfo.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ExceptionResult.class)))
    })
    @GetMapping("/{dptId}")
    public DptInfo departmentDetails(@PathVariable @Parameter(description = "부서 Id") Long dptId){
        return departmentsService.findDepartment(dptId, null);
    }
}
