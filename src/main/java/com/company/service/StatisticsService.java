package com.company.service;


import com.company.persistence.entity.Statistics;

public interface StatisticsService {

    Statistics save(Statistics statistics);

    void delete(Long id);

    Statistics findById(Long id);

    Statistics findByUrlId(Long id);

}
