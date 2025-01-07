package org.quipu.battleglound.entity;

import jakarta.persistence.*;
import lombok.*;
import org.quipu.battleglound.util.RoomStatus;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private UUID hostId;

    @Column
    private int maxUsers;

    @Column
    private int currentUsers;

    @Column
    private RoomStatus status;
}
