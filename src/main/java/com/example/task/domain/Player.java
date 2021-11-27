package com.example.task.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GenericGenerator(
            name = "player_id",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "player_id")
            }
    )
    @GeneratedValue(generator = "player_id")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nickname;

    @Column(name = "vehicle_type")
    private int vehicleType;

    @Column(name = "waiting_time")
    private int waitingTime;


    public Player(String nickname, int vehicleType, int waitingTime) {
        this.nickname = nickname;
        this.vehicleType = vehicleType;
        this.waitingTime = waitingTime;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", vehicleType=" + vehicleType +
                ", waitingTime=" + waitingTime +
                '}';
    }

    public Player() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}