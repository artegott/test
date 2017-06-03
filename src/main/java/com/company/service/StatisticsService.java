package com.company.service;


import com.company.entity.Statistics;

public interface StatisticsService {

    Statistics add(Statistics statistics);

    void delete(long id);

    Statistics edit(Statistics statistics);

    Statistics getByUrlId(Long urlId);

}
