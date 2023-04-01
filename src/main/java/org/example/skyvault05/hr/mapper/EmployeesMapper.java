package org.example.skyvault05.hr.mapper;

import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.domain.Departments;
import org.example.skyvault05.hr.domain.Employees;
import org.example.skyvault05.hr.domain.Jobs;
import org.example.skyvault05.hr.dto.EmpDto;
import org.example.skyvault05.hr.dto.EmpModifyDto;
import org.example.skyvault05.hr.dto.EmpSaveDto;
import org.example.skyvault05.hr.exception.NoParameterException;
import org.example.skyvault05.hr.exception.NoResultException;
import org.example.skyvault05.hr.repository.DepartmentsRepository;
import org.example.skyvault05.hr.repository.EmployeesRepository;
import org.example.skyvault05.hr.repository.JobsRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class EmployeesMapper {
    private final EmployeesRepository employeesRepository;
    private final JobsRepository jobsRepository;
    private  final DepartmentsRepository departmentsRepository;

    public Employees replaceFromModifyDtoForSave(Employees entity, EmpModifyDto dto){
        Departments dpt = new Departments();
        Jobs jobs = new Jobs();
        Employees manager = new Employees();

        dpt.setDepartmentId(dto.getDepartmentId());
        jobs.setJobId(dto.getJobId());
        manager.setEmployeeId(dto.getManagerId());

        if(dto == null) throw new NoParameterException();
        if(dto.getFirstName() != null || !StringUtils.hasText(dto.getFirstName())) entity.setFirstName(dto.getFirstName());
        if(dto.getLastName() != null || !StringUtils.hasText(dto.getLastName())) entity.setLastName(dto.getLastName());
        if(dto.getEmail() != null || !StringUtils.hasText(dto.getEmail())) entity.setEmail(dto.getEmail());
        if(dto.getPhoneNumber() != null || !StringUtils.hasText(dto.getPhoneNumber())) entity.setPhoneNumber(dto.getPhoneNumber());
        if(dto.getHireDate() != null) entity.setHireDate(dto.getHireDate());
        if(dto.getJobId() != null || !StringUtils.hasText(dto.getJobId())) {
//            entity.setJobs(jobsRepository.findById(dto.getJobId()).orElseThrow(() -> new NoResultException("해당 직무를 찾을 수 없습니다.")));
            entity.setJobs(jobs);
        }
        if(dto.getSalary() != null) entity.setSalary(dto.getSalary());
        if(dto.getCommissionPct() != null) entity.setCommissionPct(dto.getCommissionPct());
        if(dto.getManagerId() != null) {
//            entity.setManager(employeesRepository.findById(dto.getManagerId()).orElseThrow(() -> new NoResultException("해당 매니저를 찾을 수 없습니다.")));
            entity.setManager(manager);
        };
        if(dto.getDepartmentId() != null) {
//            entity.setDepartments(departmentsRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new NoResultException("해당 부서를 찾을 수 없습니다.")));
            entity.setDepartments(dpt);
        };

        return entity;
    }

    public EmpDto entityToDto(Employees entity){
        EmpDto dto = new EmpDto(
                entity.getEmployeeId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getHireDate(),
                entity.getJobs().getJobId(),
                entity.getSalary(),
                entity.getCommissionPct(),
                entity.getManager().getFirstName().concat(" ").concat(entity.getLastName()),
                entity.getDepartments().getDepartmentName()
        );

        return dto;
    }

    public Employees DtoToEntity(EmpSaveDto dto){
        Employees entity = new Employees();

        if(dto == null) throw new NoParameterException();
        if(dto.getEmployeeId() != null) entity.setEmployeeId(dto.getEmployeeId());
        if(dto.getFirstName() != null || !StringUtils.hasText(dto.getFirstName())) entity.setFirstName(dto.getFirstName());
        if(dto.getLastName() != null || !StringUtils.hasText(dto.getLastName())) entity.setLastName(dto.getLastName());
        if(dto.getEmail() != null || !StringUtils.hasText(dto.getEmail())) entity.setEmail(dto.getEmail());
        if(dto.getPhoneNumber() != null || !StringUtils.hasText(dto.getPhoneNumber())) entity.setPhoneNumber(dto.getPhoneNumber());
        if(dto.getHireDate() != null) entity.setHireDate(dto.getHireDate());
        if(dto.getJobId() != null || !StringUtils.hasText(dto.getJobId())) {
            entity.setJobs(jobsRepository.findById(dto.getJobId()).orElseThrow(() -> new NoResultException("해당 직무를 찾을 수 없습니다.")));
        }
        if(dto.getSalary() != null) entity.setSalary(dto.getSalary());
        if(dto.getCommissionPct() != null) entity.setCommissionPct(dto.getCommissionPct());
        if(dto.getManagerId() != null) {
            entity.setManager(employeesRepository.findById(dto.getManagerId()).orElseThrow(() -> new NoResultException("해당 매니저를 찾을 수 없습니다.")));
        };
        if(dto.getDepartmentId() != null) {
            entity.setDepartments(departmentsRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new NoResultException("해당 부서를 찾을 수 없습니다.")));
        };

        return entity;
    }
}
