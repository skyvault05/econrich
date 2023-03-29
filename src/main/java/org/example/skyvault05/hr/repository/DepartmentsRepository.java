package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.domain.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
}
