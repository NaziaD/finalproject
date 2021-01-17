package com.example.demo.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="covidstats")
public class covid {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "state")
    private String state;

    @Column(name = "date")
    private String date;

    @Column(name = "positive")
    private String positive;

    @Column(name = "death")
    private String death;

    @Column(name = "Increasedby")
    private String increasedby;

    public covid(){}

    public covid(String id, String state, String date, String positive, String death, String increasedby){
        this.id = id;
        this.state = state;
        this.date = date;
        this.positive = positive;
        this.death = death;
        this.increasedby = increasedby;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getIncreasedby() {
        return increasedby;
    }

    public void setIncreasedby(String increasedby) {
        this.increasedby = increasedby;
    }
}
