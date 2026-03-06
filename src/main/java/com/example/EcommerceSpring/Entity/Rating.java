package com.example.EcommerceSpring.Entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating extends BaseEntity{
    public double rate;
    public int count;
}
