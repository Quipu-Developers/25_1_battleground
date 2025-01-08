package org.quipu.battleground.service;

import lombok.RequiredArgsConstructor;
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

    public List<RoomDto> getRooms() {
        return roomRepository.findAll().stream()
                .map(Room::toDto)
                .toList();
    }

    public RoomDto createRoom(RoomCreateRequestDto dto) {
        Room newRoom = Room.builder()
                .title(dto.getTitle())
                .hostId(dto.getHostId())
                .maxUsers(dto.getMaxUsers())
                .currentUsers(dto.getCurrentUsers())
                .status(RoomStatus.WAITING)
                .build();

        Room room = roomRepository.save(newRoom);

        return room.toDto();
    }
}
