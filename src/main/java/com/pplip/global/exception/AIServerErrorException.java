package com.pplip.global.exception;

import com.pplip.global.api.code.ErrorCode;

public class AIServerErrorException extends AbstractErrorException {

	public AIServerErrorException() {
		super(ErrorCode.AI_SERVER_PROCESS_ERROR);
	}

	public AIServerErrorException(ErrorCode errorCode) {
		super(errorCode);
	}
}
