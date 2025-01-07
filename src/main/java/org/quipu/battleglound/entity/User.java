package org.quipu.battleglound.entity;

import jakarta.persistence.*;
import lombok.*;
import org.quipu.battleglound.util.UserStatus;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
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
