package org.quipu.battleground.dto.room;

import lombok.Builder;
import lombok.Data;
import org.quipu.battleground.util.RoomStatus;

import java.util.UUID;

@Data
@Builder
public class RoomDto {
    private UUID id;
    private String title;
    private UUID hostId;
    private int maxUsers;
    private int currentUsers;
    private RoomStatus status;
}
