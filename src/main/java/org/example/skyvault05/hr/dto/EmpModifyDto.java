package org.example.skyvault05.hr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class EmpModifyDto {
    @Schema(description = "사원 이름", example = "Bruce")
    private String firstName;
    @Schema(description = "사원 성", example = "Ernst")
    private String lastName;
    @Schema(description = "사원 이메일", example = "BERNST")
    private String email;
    @Schema(description = "사원 전화번호", example = "590.423.4568")
    private String phoneNumber;
    @Schema(description = "고용 일자", type="string" ,format = "date", example = "2022-03-02T10:15:30")
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Seoul")
    private LocalDateTime hireDate;
    @Schema(description = "사원 직무", example = "IT_PROG")
    private String jobId;
    @Schema(description = "사원 연봉", example = "9000")
    private BigDecimal salary;
    @Schema(description = "커미션 비율", example = "0.4")
    private BigDecimal commissionPct;
    @Schema(description = "매니저 ID", example = "104")
    private Long managerId;
    @Schema(description = "부서 ID", example = "30")
    private Long departmentId;
}
