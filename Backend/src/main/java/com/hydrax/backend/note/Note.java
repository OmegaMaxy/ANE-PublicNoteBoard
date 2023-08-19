package com.hydrax.backend.note;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;
    private Long user_id;
    private LocalDate date;
    @Transient
    private Integer days_ago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getDays_ago() {
        return Period.between(this.date, LocalDate.now()).getDays();
    }

    public void setDays_ago(int days_ago) {
        this.days_ago = days_ago;
    }
}
