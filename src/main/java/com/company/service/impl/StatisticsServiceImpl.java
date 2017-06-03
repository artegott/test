package com.company.service.impl;

import com.company.entity.Statistics;
import com.company.repository.StatisticsRepository;
import com.company.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service(value = "statisticsService")
@Transactional
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository repository;

    @Autowired
    public StatisticsServiceImpl(StatisticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Statistics add(Statistics statistics) {
        return repository.saveAndFlush(statistics);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Statistics edit(Statistics statistics) {
        return repository.saveAndFlush(statistics);
    }

    @Override
    public Statistics getByUrlId(Long urlId) {
        return repository.findByUrlId(urlId);
    }

}