package com.example.ChatGpt.dao;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "chats")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Chats {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "dateTime")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp dateTime;

    @Column(name = "request")
    private String request;

    @Column(name = "response")
    private String response;

}
