package org.example.skyvault05.hr.repository;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.EmpDto;
import org.example.skyvault05.hr.dto.EmpModifyDto;
import org.example.skyvault05.hr.dto.QEmpDto;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Optional;

import static org.example.skyvault05.hr.domain.QEmployees.employees;
import static org.example.skyvault05.hr.domain.QJobs.jobs;

@RequiredArgsConstructor
public class EmployeesRepositoryImpl implements EmployeesRepositoryCustom{
    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<EmpDto> findDynamicQuery(Long empId, String firstName, String lastName) {
        return Optional.ofNullable(jpaQueryFactory
                .select(
                        new QEmpDto(
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

    @Override
    public Long multiplyDptSalary(Long dptId, Float multiply) {
        JPQLQuery<BigDecimal> subQuery = JPAExpressions.select(jobs.maxSalary).from(jobs).where(jobs.jobId.eq(employees.jobs.jobId));
        //Job의 상한 salary보다 낮을 경우.
        Long count1 = jpaQueryFactory
                .update(employees)
                .set(employees.salary, employees.salary.multiply(multiply))
                .where(
                        employees.salary.multiply(multiply).loe(subQuery),
                        eqDptId(dptId)
                )
                .execute();

        em.flush();
        em.clear();

        //Job의 상한 salary보다 높을 경우.
        Long count2 = jpaQueryFactory
                .update(employees)
                .set(employees.salary, subQuery)
                .where(
                        employees.salary.multiply(multiply).gt(subQuery),
                        eqDptId(dptId)
                )
                .execute();

        em.flush();
        em.clear();

        return count1+count2;
    }

    @Override
    public Boolean updateWithModifyDto(Long empId, EmpModifyDto dto){
        UpdateClause<JPAUpdateClause> updateClause = jpaQueryFactory.update(employees);
        if(dto.getFirstName() != null) updateClause.set(employees.firstName, dto.getFirstName());
        if(dto.getLastName() != null) updateClause.set(employees.lastName, dto.getLastName());
        if(dto.getEmail() != null) updateClause.set(employees.email, dto.getEmail());
        if(dto.getPhoneNumber() != null) updateClause.set(employees.phoneNumber, dto.getPhoneNumber());
        if(dto.getHireDate() != null) updateClause.set(employees.hireDate, dto.getHireDate());
        if(dto.getJobId() != null) updateClause.set(employees.jobs.jobId, dto.getJobId());
        if(dto.getSalary() != null) updateClause.set(employees.salary, dto.getSalary());
        if(dto.getCommissionPct() != null) updateClause.set(employees.commissionPct, dto.getCommissionPct());
        if(dto.getManagerId() != null) updateClause.set(employees.manager.employeeId, dto.getManagerId());
        if(dto.getDepartmentId() != null) updateClause.set(employees.departments.departmentId, dto.getDepartmentId());

        updateClause
                .where(eqId(empId))
                .execute();

        em.flush();
        em.clear();

        return true;
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
        return employees.lastName.eq(lastName);
    }

    private BooleanExpression eqDptId(Long dptId) {
        if (dptId == null) {
            return null;
        }
        return employees.departments.departmentId.eq(dptId);
    }
}
