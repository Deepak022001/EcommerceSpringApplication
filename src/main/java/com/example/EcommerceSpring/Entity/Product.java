package com.example.EcommerceSpring.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseEntity {

    public String title;
    public double price;
    public String description;
    public String category;
    public String image;
    @ManyToOne
    @JoinColumn(name = "rating_id")
    public Rating rating;
}
