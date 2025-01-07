package org.quipu.battleglound.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.quipu.battleglound.service.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/room")
@RequiredArgsConstructor
@RestController
@Tag(name = "게임 방", description = "게임 방 관련 API")
public class RoomController {
    private final RoomService roomService;
}
