package org.quipu.battleground.dto.room;

import lombok.Data;

import java.util.UUID;

@Data
public class RoomCreateRequestDto {
    private String title;
    private UUID hostId;
    private int maxUsers;
}

