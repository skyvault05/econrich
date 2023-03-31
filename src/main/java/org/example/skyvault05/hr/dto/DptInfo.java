package org.example.skyvault05.hr.dto;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class DptInfo {
    @Schema(description = "부서 ID", example = "80")
    private Long departmentId;
    @Schema(description = "부서 이름", example = "Sales")
    private String departmentName;
    @Schema(description = "매니저 이름", example = "John John")
    private String managerName;
    @Schema(description = "위치 정보")
    private LocInfo location;

    @QueryProjection
    public DptInfo(Long departmentId, String departmentName, String managerName, LocInfo location) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerName = managerName;
        this.location = location;
    }
}
