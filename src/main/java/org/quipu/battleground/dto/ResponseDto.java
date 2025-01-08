package org.quipu.battleground.dto;

import lombok.Data;


@Data
// 모든 응답을 정의하는 DTO 객체
public class ResponseDto<T> {
    private final int code;
    private final String message;
    private final T data;
}
