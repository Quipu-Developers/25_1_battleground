package org.quipu.battleground.entity;

import jakarta.persistence.*;
import lombok.*;
import org.quipu.battleground.dto.room.RoomDto;
import org.quipu.battleground.util.RoomStatus;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private UUID hostId;

    @Column(nullable = false)
    private int maxUsers;

    @Column(nullable = false)
    private int currentUsers;

    @Column(nullable = false)
    private RoomStatus status;

    public RoomDto toDto() {
        return RoomDto.builder()
                .id(this.id)
                .title(this.title)
                .hostId(this.hostId)
                .maxUsers(this.maxUsers)
                .currentUsers(this.currentUsers)
                .status(this.status)
                .build();
    }
}
