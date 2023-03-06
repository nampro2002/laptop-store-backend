package com.example.backendspringboot.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    // @Column(columnDefinition="nvarchar(max)")
    @Column(columnDefinition="TEXT") 
    private String description;
    private String webUrl;
    
    @OneToMany(mappedBy = "category")
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong khi equals và
    @ToString.Exclude // Không sử dụng trong khi toString()
    @JsonIgnore
    private List<Product> products;
}
