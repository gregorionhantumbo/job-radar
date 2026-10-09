package com.gregorio.job_radar.modules.users.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {

    private UUID uuid;
    private String fullName;
    private String username;
    private String password;
    private String contact;
    private String title;
    private String email;

    private Set<Skill> skills;
    private Set<UUID> favoriteJobIds;

    private boolean deleted;

    public User() {
        this.skills = new HashSet<>();
        this.favoriteJobIds = new HashSet<>();
        this.deleted = false;
    }

    public User(
            UUID uuid,
            String fullName,
            String username,
            String password,
            String contact,
            String title,
            String email,
            Set<Skill> skills
    ) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.title = title;
        this.email = email;
        this.skills = skills != null
                ? new HashSet<>(skills)
                : new HashSet<>();
        this.favoriteJobIds = new HashSet<>();
        this.deleted = false;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills != null
                ? new HashSet<>(skills)
                : new HashSet<>();
    }

    public Set<UUID> getFavoriteJobIds() {
        return favoriteJobIds;
    }

    public void setFavoriteJobIds(Set<UUID> favoriteJobIds) {
        this.favoriteJobIds = favoriteJobIds != null
                ? new HashSet<>(favoriteJobIds)
                : new HashSet<>();
    }

    public void addFavoriteJob(UUID jobUuid) {
        if (jobUuid == null) {
            throw new IllegalArgumentException(
                    "Job UUID cannot be null"
            );
        }

        this.favoriteJobIds.add(jobUuid);
    }

    public void removeFavoriteJob(UUID jobUuid) {
        if (jobUuid == null) {
            return;
        }

        this.favoriteJobIds.remove(jobUuid);
    }

    public boolean isFavoriteJob(UUID jobUuid) {
        return jobUuid != null
                && this.favoriteJobIds.contains(jobUuid);
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void delete() {
        this.deleted = true;
    }

    public void restore() {
        this.deleted = false;
    }
}