package com.company.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "url_id", nullable = false)
    private Url url;
    @Column(name = "pc_click", nullable = false)
    private Long countPcClick = 0L;
    @Column(name = "mb_click", nullable = false)
    private Long countMobileClick = 0L;
    @Column(name = "tb_click", nullable = false)
    private Long countTabletClick = 0L;

    public Statistics() {
    }

    public Statistics(Url url, Long countPcClick, Long countMobileClick, Long countTabletClick) {
        this.url = url;
        this.countPcClick = countPcClick;
        this.countMobileClick = countMobileClick;
        this.countTabletClick = countTabletClick;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Long getCountPcClick() {
        return countPcClick;
    }

    public void setCountPcClick(Long countPcClick) {
        this.countPcClick = countPcClick;
    }

    public Long getCountMobileClick() {
        return countMobileClick;
    }

    public void setCountMobileClick(Long countMobileClick) {
        this.countMobileClick = countMobileClick;
    }

    public Long getCountTabletClick() {
        return countTabletClick;
    }

    public void setCountTabletClick(Long countTabletClick) {
        this.countTabletClick = countTabletClick;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", countPcClick=" + countPcClick +
                ", countMobileClick=" + countMobileClick +
                ", countTabletClick=" + countTabletClick +
                '}';
    }
}
