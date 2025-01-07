package org.quipu.battleground.service;

import lombok.RequiredArgsConstructor;
import org.quipu.battleground.dto.room.RoomCreateRequestDto;
import org.quipu.battleground.dto.room.RoomCreateResponseDto;
import org.quipu.battleground.dto.room.RoomDto;
import org.quipu.battleground.entity.Room;
import org.quipu.battleground.repository.RoomRepository;
import org.quipu.battleground.util.RoomStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<RoomDto> getRooms() {
        return roomRepository.findAll().stream()
                .map(Room::toDto)
                .collect(Collectors.toList());
    }

    public RoomCreateResponseDto createRoom(RoomCreateRequestDto dto) {
        roomRepository.save(
                new Room().builder()
                        .title(dto.getTitle())
                        .hostId(dto.getHostId())
                        .maxUsers(dto.getMaxUsers())
                        .currentUsers(dto.getCurrentUsers())
                        .status(new RoomStatus("WAITING"))
        );
    }
}
