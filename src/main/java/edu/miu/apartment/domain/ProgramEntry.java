package edu.miu.apartment.domain;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ProgramEntry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long entryId;
    @Column(unique = true)
    @NotEmpty(message = "{NotEmpty}")
    private String entryName;
    @FutureOrPresent(message = "{FutureOrPresent}")
    private Date entryStartDate;
    @Future(message = "{Future}")
    private Date entryEndDate;

    private String entryStatus;

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public Date getEntryStartDate() {
        return entryStartDate;
    }

    public void setEntryStartDate(Date entryStartDate) {
        this.entryStartDate = entryStartDate;
    }

    public Date getEntryEndDate() {
        return entryEndDate;
    }

    public void setEntryEndDate(Date entryEndDate) {
        this.entryEndDate = entryEndDate;
    }

    public String getEntryStatus() {
        return entryStatus;
    }

    public void setEntryStatus(String entryStatus) {
        this.entryStatus = entryStatus;
    }
}
