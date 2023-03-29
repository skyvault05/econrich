package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.domain.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, String> {
}
