package org.example.skyvault05.hr.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.DptInfo;
import org.example.skyvault05.hr.dto.QDptInfo;
import org.example.skyvault05.hr.dto.QLocInfo;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.example.skyvault05.hr.domain.QDepartments.departments;
import static org.example.skyvault05.hr.domain.QEmployees.employees;

@RequiredArgsConstructor
public class DepartmentsRepositoryImpl implements DepartmentsRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public DptInfo findDynamicQuery(Long dptId, String dptName) {
        return jpaQueryFactory.select(
                new QDptInfo(
                        departments.departmentId,
                        departments.departmentName,
                        departments.manager.firstName.concat(" ").concat(departments.manager.firstName),
                        new QLocInfo(
                                departments.locations.locationId,
                                departments.locations.streetAddress,
                                departments.locations.postalCode,
                                departments.locations.city,
                                departments.locations.stateProvince,
                                departments.locations.countries.countryName
                        )
                    )
                )
                .from(departments)
                .where(
                        eqDptId(dptId),
                        eqDptName(dptName)
                )
                .fetchOne();
    }

    private BooleanExpression eqDptId(Long dptId) {
        if (dptId == null) {
            return null;
        }
        return departments.departmentId.eq(dptId);
    }

    private BooleanExpression eqDptName(String dptName) {
        if (!StringUtils.hasText(dptName)) {
            return null;
        }
        return departments.departmentName.eq(dptName);
    }
}
