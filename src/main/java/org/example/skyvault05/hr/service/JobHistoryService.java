package org.example.skyvault05.hr.service;

import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.JobHistDto;
import org.example.skyvault05.hr.exception.NoParameterException;
import org.example.skyvault05.hr.exception.NoResultException;
import org.example.skyvault05.hr.repository.JobHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobHistoryService {
    private final JobHistoryRepository jobHistoryRepository;

    public List<JobHistDto> findJobHist(Long empId){
        if(empId == null) throw new NoParameterException();
        List<JobHistDto> jobHistDtoList = jobHistoryRepository.findDynamicQuery(empId, null);
        if (jobHistDtoList.isEmpty()) throw new NoResultException();

        return jobHistDtoList;
    }
}
