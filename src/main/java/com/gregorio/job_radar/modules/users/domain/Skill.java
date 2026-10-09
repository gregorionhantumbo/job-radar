
package com.gregorio.job_radar.modules.users.domain;

import java.util.UUID;

public class Skill {

    private UUID uuid;
    private String skillName;
    private SkillLevel level;
    private boolean deleted;

    public Skill() {
        this.deleted = false;
    }

    public Skill(
            UUID uuid,
            String skillName,
            SkillLevel level
    ) {
        this.uuid = uuid;
        this.skillName = skillName;
        this.level = level;
        this.deleted = false;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
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