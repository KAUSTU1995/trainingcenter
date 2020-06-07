package com.liv2train.model;

import com.liv2train.utils.Constants;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.liv2train.utils.Constants.*;

@Entity
@Table(name = TRAININGCENTERS)
public class TrainingCenter {


    @Id
    private UUID uuid;

    @Size(max = 40, message = MAXIMUM_40_CHARACTERS_ALLOWED)
    private String centerName;

    @Size(max = 12, message = SIZE_SHOULD_BE_MAXIMUM_12)
    @Pattern(regexp = CENTER_CODE_MATCH, message = INVALID_CENTER_CODE)
    private String centerCode;

    private long capacity;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @Column(name = COURSES)
    @Fetch(FetchMode.SUBSELECT)
    @CollectionTable(name = TRAININGCENTER_COURSES, joinColumns = @JoinColumn(name = TRAININGCENTER_UUID))
    private List<String> courses;

    private long createdOn;

    @Email(message = NOT_A_VALID_EMAIL)
    private String contactEmail;

    @Pattern(regexp = MOBILE_MATCH, message = INVALID_MOBILE_NUMBER)
    private String contactPhone;

    public TrainingCenter(String centerName, String centerCode, long capacity, String contactEmail
            , String contactPhone) {
        this.setUuid();
        this.centerName = centerName;
        this.centerCode = centerCode;
        this.capacity = capacity;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }


    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public TrainingCenter() {
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn() {
        this.createdOn = new Date().getTime();
    }

    @CollectionTable(name = TRAININGCENTER_ADDRESSES, joinColumns = @JoinColumn(name = TRAININGCENTER_UUID))
    @AttributeOverrides({
            @AttributeOverride(name = ADDRESS_LINE_1, column = @Column(name = HOUSE_NUMBER)),
            @AttributeOverride(name = ADDRESS_LINE_2, column = @Column(name = STREET))
    })
    private Address addresses;

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }


    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }
}
