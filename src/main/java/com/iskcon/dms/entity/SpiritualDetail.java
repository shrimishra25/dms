package com.iskcon.dms.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "spiritual_details")
public class SpiritualDetail {

    public SpiritualDetail() {

    }

    public SpiritualDetail(Integer id, int chantingRound, String bookReading,
                           String service, String course,
                           String counsellor, String mentor,
                           String initiationStatus) {
        this.id = id;
        this.chantingRound = chantingRound;
        this.bookReading = bookReading;
        this.service = service;
        this.course = course;
        this.counsellor = counsellor;
        this.mentor = mentor;
        this.initiationStatus = initiationStatus;
    }

    @Id
    @Column(name = "spiritual_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Number_Of_Chanting_Rounds")
    private int chantingRound;

    @Column(name = "Prabhupada_Book_Reading")
    private String bookReading;

    //private List<Seva> service;
    @Column(name = "Service")
    private String service;

    //private List<Course> course;
    @Column(name = "ISKCON_Courses")
    private String course;

    @Column(name = "Counsellor")
    private String counsellor;

    @Column(name = "Mentor")
    private String mentor;

    @Column(name = "Initiation_status")
    private String initiationStatus;

    @Column(name = "devotee_id")
    private Integer devoteeId;

    public Integer getDevoteeId() {
        return devoteeId;
    }

    public void setDevoteeId(Integer devoteeId) {
        this.devoteeId = devoteeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getChantingRound() {
        return chantingRound;
    }

    public void setChantingRound(int chantingRound) {
        this.chantingRound = chantingRound;
    }

    public String getBookReading() {
        return bookReading;
    }

    public void setBookReading(String bookReading) {
        this.bookReading = bookReading;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCounsellor() {
        return counsellor;
    }

    public void setCounsellor(String counsellor) {
        this.counsellor = counsellor;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getInitiationStatus() {
        return initiationStatus;
    }

    public void setInitiationStatus(String initiationStatus) {
        this.initiationStatus = initiationStatus;
    }
}
