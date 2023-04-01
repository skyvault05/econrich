package org.example.skyvault05.hr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@ToString
public class JobHistDto {
    @Schema(description = "사원 ID", example = "104")
    private Long empId;
    @Schema(description = "시작 일자", type="string" ,format = "date", example = "2020-02-17")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate startDate;
    @Schema(description = "종료 일자", type="string" ,format = "date", example = "2020-03-17")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate endDate;
    @Schema(description = "사원 직무", example = "IT_PROG")
    private String jobId;
    @Schema(description = "부서 이름", example = "Sales")
    private String departmentName;

    @QueryProjection
    public JobHistDto(Long empId, LocalDate startDate, LocalDate endDate, String jobId, String departmentName) {
        this.empId = empId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobId = jobId;
        this.departmentName = departmentName;
    }
}
