package com.company.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name")
    private User user;
    @Column(nullable = false)
    private String longUrl;
    @Column(nullable = false, unique = true)
    private String shortUrl;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "url_tag", joinColumns = @JoinColumn(name = "url_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Tag> tags;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "url")
    private Statistics statistics;

    public Url() {
    }

    public Url(String name, String description, User user, String longUrl, String shortUrl, Set<Tag> tags, Statistics statistics) {
        this.name = name;
        this.description = description;
        this.user = user;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.tags = tags;
        this.statistics = statistics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", longUrl='" + longUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", tags=" + tags +
                ", statistics=" + statistics +
                '}';
    }
}
