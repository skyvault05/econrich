package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.domain.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long>, EmployeesRepositoryCustom {
}
