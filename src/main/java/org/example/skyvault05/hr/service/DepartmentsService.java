package org.example.skyvault05.hr.service;

import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.DptInfo;
import org.example.skyvault05.hr.exception.NoParameterException;
import org.example.skyvault05.hr.repository.DepartmentsRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;

    public DptInfo findDepartment(Long dptId, String dptName) {
        if((dptId == null) && (StringUtils.hasText(dptName) || dptName == null)) throw new NoParameterException();
        return departmentsRepository.findDynamicQuery(dptId, null);
    }
}
