package org.quipu.battleglound.service;

import lombok.RequiredArgsConstructor;
import org.quipu.battleglound.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

}
