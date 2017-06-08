package com.company.persistence.repository;

import com.company.persistence.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    Statistics findByUrlId(Long urlId);
}
