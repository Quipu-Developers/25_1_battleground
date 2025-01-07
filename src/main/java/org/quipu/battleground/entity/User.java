package org.quipu.battleground.entity;

import jakarta.persistence.*;
import lombok.*;
import org.quipu.battleground.util.UserStatus;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String studentId;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private UserStatus status;
}
