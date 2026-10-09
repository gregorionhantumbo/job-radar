package com.gregorio.job_radar.modules.users.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "g28_users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String contact;

    private String title;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean deleted;

    @ManyToMany
    @JoinTable(
            name = "g28_user_skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<SkillEntity> skills = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "g28_user_favorite_jobs",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "job_id", nullable = false)
    private Set<UUID> favoriteJobIds = new HashSet<>();
}