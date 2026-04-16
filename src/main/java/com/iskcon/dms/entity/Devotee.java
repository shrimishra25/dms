package com.iskcon.dms.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "devotees")
public class Devotee {

    public Devotee() {
    }

    public Devotee(Integer id, String name, String address, Long mobile,
                   String datOfBirth, Long age, String education,
                   String maritalStatus, String anniversary,
                   String pan, String workExperiance, String email,
                   SpiritualDetail spiritualDetail) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.datOfBirth = datOfBirth;
        this.age = age;
        this.education = education;
        this.maritalStatus = maritalStatus;
        this.anniversary = anniversary;
        this.pan = pan;
        this.workExperiance = workExperiance;
        this.email = email;
        this.spiritualDetail = spiritualDetail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "devotee_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Mobile")
    private Long mobile;

    @Column(name = "DOB")
    private String datOfBirth;

    @Column(name = "Age")
    private Long age;

    @Column(name = "Education")
    private String education;

    @Column(name = "Marital_Status")
    private String maritalStatus;

    @Column(name = "Anniversery")
    private String anniversary;

    @Column(name = "PAN")
    private String pan;

    @Column(name = "Work_Experience_Skills")
    private String workExperiance;

    @Column(name = "Email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "devotee_id")
    private SpiritualDetail spiritualDetail;

    public SpiritualDetail getSpiritualDetail() {
        return spiritualDetail;
    }

    public void setSpiritualDetail(SpiritualDetail spiritualDetail) {
        this.spiritualDetail = spiritualDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getDatOfBirth() {
        return datOfBirth;
    }

    public void setDatOfBirth(String datOfBirth) {
        this.datOfBirth = datOfBirth;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public void setAnniversary(String anniversary) {
        this.anniversary = anniversary;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getWorkExperiance() {
        return workExperiance;
    }

    public void setWorkExperiance(String workExperiance) {
        this.workExperiance = workExperiance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
