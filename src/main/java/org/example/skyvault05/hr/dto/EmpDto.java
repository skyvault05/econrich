package org.example.skyvault05.hr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@ToString
public class EmpDto {
    @Schema(description = "사원 ID", example = "104")
    private Long employeeId;
    @Schema(description = "사원 이름", example = "Bruce")
    private String firstName;
    @Schema(description = "사원 성", example = "Ernst")
    private String lastName;
    @Schema(description = "사원 이메일", example = "BERNST")
    private String email;
    @Schema(description = "사원 전화번호", example = "590.423.4568")
    private String phoneNumber;
    @Schema(description = "고용 일자", type="string" ,format = "date", example = "2020-02-17")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime hireDate;
    @Schema(description = "사원 직무", example = "IT_PROG")
    private String job;
    @Schema(description = "사원 연봉", example = "9000")
    private BigDecimal salary;
    @Schema(description = "커미션 비율", example = "0.4")
    private BigDecimal commissionPct;
    @Schema(description = "매니저 이름", example = "Steven King")
    private String manager;
    @Schema(description = "부서 이름", example = "Sales")
    private String department;


    @QueryProjection
    public EmpDto(Long employeeId, String firstName, String lastName, String email, String phoneNumber, LocalDateTime hireDate, String job, BigDecimal salary, BigDecimal commissionPct, String manager, String department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.job = job;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.manager = manager;
        this.department = department;
    }
}
