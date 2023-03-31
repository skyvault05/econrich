package org.example.skyvault05.hr.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.domain.QJobHistory;
import org.example.skyvault05.hr.dto.JobHistInfo;
import org.example.skyvault05.hr.dto.QJobHistInfo;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.example.skyvault05.hr.domain.QEmployees.employees;
import static org.example.skyvault05.hr.domain.QJobHistory.jobHistory;
import static org.example.skyvault05.hr.domain.QJobHistoryId.jobHistoryId;

@RequiredArgsConstructor
public class JobHistoryRepositoryImpl implements JobHistoryRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<JobHistInfo> findDynamicQuery(Long empId, LocalDate startDate) {
        return jpaQueryFactory
                .select(
                        new QJobHistInfo(
                                jobHistory.jobHistoryId.employees.employeeId,
                                jobHistory.jobHistoryId.startDate,
                                jobHistory.endDate,
                                jobHistory.jobs.jobId,
                                jobHistory.departments.departmentName
                        )
                )
                .from(jobHistory)
                .where(
                        eqEmpId(empId),
                        eqStartDate(startDate)
                ).fetch();
    }

    private BooleanExpression eqEmpId(Long empId) {
        if (empId == null) {
            return null;
        }
        return jobHistory.jobHistoryId.employees.employeeId.eq(empId);
    }

    private BooleanExpression eqStartDate(LocalDate startDate){
        if (startDate == null) {
            return null;
        }
        return jobHistory.jobHistoryId.startDate.eq(startDate);
    }
}
