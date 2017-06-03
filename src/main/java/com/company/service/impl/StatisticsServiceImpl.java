package com.company.service.impl;

import com.company.entity.Statistics;
import com.company.repository.StatisticsRepository;
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
    private final Logger logger = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    @Autowired
    public StatisticsServiceImpl(StatisticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Statistics statistics) {
        repository.save(statistics);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(Statistics statistics) {
        if (statistics.getId() != null) {
            repository.save(statistics);
        } else {
            logger.error(String.format("The object %s doesn't exist", statistics));
        }
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