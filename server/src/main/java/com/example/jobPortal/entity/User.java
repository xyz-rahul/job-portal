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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    private String username;
    private String password;

    @Column(nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            joinColumns = @JoinColumn(name = "user_id")
    )
    private List<String> skills = new ArrayList<>();

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            joinColumns = @JoinColumn(name = "user_id")
    )
    private List<String> education = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            joinColumns = @JoinColumn(name = "user_id")
    )
    private List<String> experiences;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
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
