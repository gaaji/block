package com.gaaji.block.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum BlockErrorCode implements ErrorCode {


	SELF_BLOCK(HttpStatus.BAD_REQUEST, "b-0001","자기 자신은 차단 할 수 없습니다."),
	NO_SEARCH(HttpStatus.BAD_REQUEST, "b-0002","차단 해제 대상자를 찾지 못했습니다."),
    ;
	
	private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    public String getErrorName() {
        return this.name();
    }
}
