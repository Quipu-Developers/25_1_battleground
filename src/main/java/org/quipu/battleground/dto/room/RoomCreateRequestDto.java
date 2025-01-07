package org.quipu.battleground.dto.room;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class RoomCreateRequestDto {
    @NotBlank
    private String title;
    private UUID hostId;
    private int maxUsers;
    private int currentUsers;
}

