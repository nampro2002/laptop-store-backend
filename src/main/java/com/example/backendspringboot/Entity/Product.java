package com.example.backendspringboot.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private double rate;
    // @Column(columnDefinition="nvarchar(max)")
    @Column(columnDefinition="TEXT") 
    private String imageUrl;
    @OneToMany(mappedBy = "product", fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong khi equals và
    @ToString.Exclude // Không sử dụng trong khi toString()
    @JsonIgnore
    private List<Cart> cart;
    
    @ManyToOne
    @JoinColumn(name = "category_id") // thông qua khóa ngoại address_id
    private Category category;
}
