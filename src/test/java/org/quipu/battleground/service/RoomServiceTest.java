package org.quipu.battleground.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.quipu.battleground.dto.room.RoomCreateRequestDto;
import org.quipu.battleground.dto.room.RoomDto;
import org.quipu.battleground.entity.Room;
import org.quipu.battleground.repository.RoomRepository;
import org.quipu.battleground.util.RoomStatus;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceTest {
    @InjectMocks
    private RoomService roomService;

    @Mock
    private RoomRepository roomRepository;

    @BeforeEach
    void setUp() {
        Room mockRoom = Room.builder()
                .id(UUID.randomUUID())
                .title("Test Room")
                .hostId(UUID.randomUUID())
                .maxUsers(10)
                .currentUsers(5)
                .status(RoomStatus.WAITING)
                .build();

        Mockito.when(roomRepository.findAll()).thenReturn(Collections.singletonList(mockRoom));
    }

    @Test
    @DisplayName("방 조회 테스트")
    void getRooms() {
        // When
        List<RoomDto> result = roomService.getRooms();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Room", result.getFirst().getTitle());
    }

    @Test
    @DisplayName("방 생성 테스트")
    void createRoom() {
        // Given
        RoomCreateRequestDto requestDto = new RoomCreateRequestDto();
        requestDto.setTitle("New Room");
        requestDto.setHostId(UUID.randomUUID());
        requestDto.setMaxUsers(10);
        requestDto.setCurrentUsers(0);

        Room mockRoom = Room.builder()
                .id(UUID.randomUUID())
                .title("New Room")
                .hostId(requestDto.getHostId())
                .maxUsers(requestDto.getMaxUsers())
                .currentUsers(requestDto.getCurrentUsers())
                .status(RoomStatus.WAITING)
                .build();

        Mockito.when(roomRepository.save(Mockito.any(Room.class))).thenReturn(mockRoom);

        // When
        RoomDto result = roomService.createRoom(requestDto);
        System.out.println(result);

        // Then
        assertNotNull(result);
        assertEquals("New Room", result.getTitle());
    }
}
