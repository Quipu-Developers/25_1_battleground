package org.quipu.battleground.dto.room;

import lombok.Data;

@Data
public class RoomEditRequestDto {
    private String title;
    private int maxUsers;
    private int currentUsers;
}
