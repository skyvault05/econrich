package org.example.skyvault05.hr.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.EmpInfo;
import org.example.skyvault05.hr.dto.QEmpInfo;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static org.example.skyvault05.hr.domain.QEmployees.employees;

@RequiredArgsConstructor
public class EmployeesRepositoryImpl implements EmployeesRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<EmpInfo> findDynamicQuery(Long empId, String firstName, String lastName) {
        return Optional.ofNullable(jpaQueryFactory
                .select(
                        new QEmpInfo(
                                employees.employeeId,
                                employees.firstName,
                                employees.lastName,
                                employees.email,
                                employees.phoneNumber,
                                employees.hireDate,
                                employees.jobs.jobId,
                                employees.salary,
                                employees.commissionPct,
                                (employees.manager.firstName.concat(" ").concat(employees.manager.lastName)),
                                employees.departments.departmentName
                        )
                )
                .from(employees)
                .where(
                        eqId(empId),
                        eqFirstName(firstName),
                        eqLastName(lastName)
                )
                .fetchOne());
    }

    private BooleanExpression eqId(Long empId) {
        if (empId == null) {
            return null;
        }
        return employees.employeeId.eq(empId);
    }

    private BooleanExpression eqFirstName(String firstName) {
        if (!StringUtils.hasText(firstName)) {
            return null;
        }
        return employees.firstName.eq(firstName);
    }

    private BooleanExpression eqLastName(String lastName) {
        if (!StringUtils.hasText(lastName)) {
            return null;
        }
        return employees.firstName.eq(lastName);
    }
}
