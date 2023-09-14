package com.example.jobPortal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 10000)
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            joinColumns = @JoinColumn(name = "job_id")
    )
    private List<String> requirement = new ArrayList<>();

    @Column(name = "experience_required")
    private String experienceRequired;

    private String workMode;

    private String industry;

    private String salaryRange;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    @OneToMany(mappedBy = "job")
    private List<Application> applicationList = new ArrayList<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
}
