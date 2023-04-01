package org.example.skyvault05.hr.dto;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class LocDto {
    @Schema(description = "위치 ID", example = "1200")
    private Long locationId;
    @Schema(description = "거리 주소", example = "2017 Shinjuku-ku")
    private String streetAddress;
    @Schema(description = "우편 주소", example = "1689")
    private String postalCode;
    @Schema(description = "City", example = "Tokyo")
    private String city;
    @Schema(description = "state/province", example = "Tokyo Prefecture")
    private String stateProvince;
    @Schema(description = "국가명", example = "Canada")
    private String countryName;

    @QueryProjection
    public LocDto(Long locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryName) {
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryName = countryName;
    }
}
