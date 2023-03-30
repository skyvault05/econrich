package org.example.skyvault05.hr.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.skyvault05.hr.domain.QRegions;
import org.example.skyvault05.hr.domain.Regions;

import java.util.List;

import static org.example.skyvault05.hr.domain.QRegions.regions;

@RequiredArgsConstructor
public class RegionsRepositoryImpl implements RegionsRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Regions> findByName(String regionName) {
        return queryFactory.selectFrom(regions)
                .where(regions.regionName.eq(regionName))
                .fetch();
    }
}
