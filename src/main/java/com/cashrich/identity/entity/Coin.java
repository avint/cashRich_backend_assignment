package com.cashrich.identity.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(schema = "coin")
public class Coin {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    Integer id;


    @Column(name = "user_id")
    Integer userId;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
