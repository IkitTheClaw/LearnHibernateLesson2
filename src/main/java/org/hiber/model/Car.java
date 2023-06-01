package org.hiber.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Long id;
    private String model;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private User owner;
}
