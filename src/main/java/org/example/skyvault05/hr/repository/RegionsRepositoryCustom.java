package org.example.skyvault05.hr.repository;

import org.example.skyvault05.hr.domain.Regions;

import java.util.List;

public interface RegionsRepositoryCustom {
    List<Regions> findByName(String name);
}
