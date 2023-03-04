package com.example.backendspringboot.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    @ManyToOne
    @JoinColumn(name = "user_id") // thông qua khóa ngoại user_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;
    private String phone;
    @Column(columnDefinition="nvarchar(max)")
    private String address;
    @Column(columnDefinition="nvarchar(max)")
    private String description;
}
