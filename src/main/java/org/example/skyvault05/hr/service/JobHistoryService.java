package org.example.skyvault05.hr.service;

import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.dto.JobHistInfo;
import org.example.skyvault05.hr.exception.NoParameterException;
import org.example.skyvault05.hr.exception.NoResultException;
import org.example.skyvault05.hr.repository.JobHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobHistoryService {
    private final JobHistoryRepository jobHistoryRepository;

    public List<JobHistInfo> findJobHist(Long empId){
        if(empId == null) throw new NoParameterException();
        List<JobHistInfo> jobHistInfoList = jobHistoryRepository.findDynamicQuery(empId, null);
        if (jobHistInfoList.isEmpty()) throw new NoResultException();

        return jobHistInfoList;
    }
}
