package org.quipu.battleground.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.quipu.battleground.dto.ResponseDto;
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
    @Operation(summary = "현재 생성되어 있는 방 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "방 조회 성공")
    })
    public ResponseDto<List<RoomDto>> getRooms() {
        return roomService.getRooms();
    }

    @PostMapping("/")
    @Operation(summary = "새로운 방 생성")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "방 생성 성공")
    })
    public ResponseDto<RoomDto> createRoom(@RequestBody RoomCreateRequestDto dto) {
        return roomService.createRoom(dto);
    }

    @PatchMapping("/{id}")
    public RoomDto editRoom(@PathVariable UUID id, @RequestBody RoomEditRequestDto dto) {
        return null;
    }
}
