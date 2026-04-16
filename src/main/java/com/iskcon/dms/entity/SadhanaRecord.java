package com.iskcon.dms.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sadhana_records")
public class SadhanaRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer devoteeId;
    private String name;
    private LocalDate date;
    @Column(name = "chanting_rounds")
    private Integer chantingRounds;
    @Column(name = "chanting_end_time")
    private String chantingEndTime;
    @Column(name = "extra_rounds")
    private Integer extraRounds;
    @Column(name = "study_time")
    private Integer studyTime;
    @Column(name = "hearing_time")
    private Integer hearingTime;
    private String service;
    @Column(name = "temple_program_attend")
    private String templeProgramAttend;
    @Column(name = "mangal_arti")
    private String mangalArti;
    @Column(name = "total_marks")
    private Integer totalMarks;
    @Column(name = "username")
    private String username;

    public Integer getDevoteeId() {
        return devoteeId;
    }

    public void setDevoteeId(Integer devoteeId) {
        this.devoteeId = devoteeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getChantingRounds() {
        return chantingRounds;
    }

    public void setChantingRounds(Integer chantingRounds) {
        this.chantingRounds = chantingRounds;
    }

    public String getChantingEndTime() {
        return chantingEndTime;
    }

    public void setChantingEndTime(String chantingEndTime) {
        this.chantingEndTime = chantingEndTime;
    }

    public Integer getExtraRounds() {
        return extraRounds;
    }

    public void setExtraRounds(Integer extraRounds) {
        this.extraRounds = extraRounds;
    }

    public Integer getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Integer studyTime) {
        this.studyTime = studyTime;
    }

    public Integer getHearingTime() {
        return hearingTime;
    }

    public void setHearingTime(Integer hearingTime) {
        this.hearingTime = hearingTime;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTempleProgramAttend() {
        return templeProgramAttend;
    }

    public void setTempleProgramAttend(String templeProgramAttend) {
        this.templeProgramAttend = templeProgramAttend;
    }

    public String getMangalArti() {
        return mangalArti;
    }

    public void setMangalArti(String mangalArti) {
        this.mangalArti = mangalArti;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
