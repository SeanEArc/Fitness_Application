package com.Arc.FitnessApp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "DAILY_LOGGED_FOOD")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class DailyLoggedFood {

    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "log_date", nullable = false)
    private LocalDate logDate;


}
