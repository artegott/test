package com.company.service;


import com.company.entity.Statistics;

public interface StatisticsService {

    void save(Statistics statistics);

    void delete(Long id);

    void update(Statistics statistics);

    Statistics findById(Long id);

    Statistics findByUrlId(Long id);

}
