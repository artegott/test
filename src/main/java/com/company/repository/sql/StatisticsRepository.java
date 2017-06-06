package com.company.repository.sql;

import com.company.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    Statistics findByUrlId(Long urlId);
}
