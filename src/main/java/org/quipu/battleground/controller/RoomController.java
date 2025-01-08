package org.quipu.battleground.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.quipu.battleground.dto.room.RoomCreateRequestDto;
import org.quipu.battleground.dto.room.RoomDto;
import org.quipu.battleground.dto.room.RoomEditRequestDto;
import org.quipu.battleground.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/rooms")
@RequiredArgsConstructor
@RestController
@Tag(name = "게임 방", description = "게임 방 관련 API")
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/")
    public List<RoomDto> getRooms() {
        return roomService.getRooms();
    }

    @PostMapping("/")
    public RoomDto createRoom(@RequestBody RoomCreateRequestDto dto) {
        return roomService.createRoom(dto);
    }

    @PatchMapping("/{id}")
    public RoomDto editRoom(@PathVariable UUID id, @RequestBody RoomEditRequestDto dto) {
        return null;
    }
}
