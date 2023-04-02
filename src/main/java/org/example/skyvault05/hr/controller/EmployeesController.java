package org.example.skyvault05.hr.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.EmpDto;
import org.example.skyvault05.hr.dto.EmpModifyDto;
import org.example.skyvault05.hr.exception.dto.ExceptionResult;
import org.example.skyvault05.hr.service.EmployeesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "employees")
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeesService employeesService;

    @Operation(summary = "특정 사원의 현재 직원 정보.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = EmpDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ExceptionResult.class)))
    })
    @GetMapping("/{empId}")
    public EmpDto empDetails(@PathVariable @Parameter(description = "직원 ID") Long empId){
        return employeesService.findEmp(empId, null, null);
    }

    @Operation(summary = "사원 정보 변경.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = EmpDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ExceptionResult.class)))
    })
    @PutMapping("/{empId}")
    public EmpDto empModify(@PathVariable @Parameter Long empId, @RequestBody EmpModifyDto empModifyDto){
        System.out.println(empId +":"+ empModifyDto);
        return employeesService.modifyEmp(empId, empModifyDto);
    }
}
