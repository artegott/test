package com.company.service.impl;

import com.company.entity.Statistics;
import com.company.repository.sql.StatisticsRepository;
import com.company.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service(value = "statisticsService")
@Transactional
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository repository;
    private final Logger log = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    @Autowired
    public StatisticsServiceImpl(StatisticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Statistics save(Statistics statistics) {
        return repository.save(statistics);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Statistics findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Statistics findByUrlId(Long id) {
        return repository.findByUrlId(id);
    }

}