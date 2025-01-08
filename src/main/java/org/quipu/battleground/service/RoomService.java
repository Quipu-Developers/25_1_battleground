package org.quipu.battleground.service;

import lombok.RequiredArgsConstructor;
import org.quipu.battleground.dto.ResponseDto;
import org.quipu.battleground.dto.room.RoomCreateRequestDto;
import org.quipu.battleground.dto.room.RoomDto;
import org.quipu.battleground.entity.Room;
import org.quipu.battleground.repository.RoomRepository;
import org.quipu.battleground.util.RoomStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public ResponseDto<List<RoomDto>> getRooms() {
        List<RoomDto> data = roomRepository.findAll().stream()
                .map(Room::toDto)
                .toList();

        return new ResponseDto<>(200, "success", data);
    }

    public ResponseDto<RoomDto> createRoom(RoomCreateRequestDto dto) {
        Room room = roomRepository.save(
                Room.builder()
                        .title(dto.getTitle())
                        .hostId(dto.getHostId())
                        .maxUsers(dto.getMaxUsers())
                        .currentUsers(1)
                        .status(RoomStatus.WAITING)
                        .build()
        );

        return new ResponseDto<>(200, "success", room.toDto());
    }
}
