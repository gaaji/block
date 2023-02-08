package com.gaaji.block.exception;

import static com.gaaji.block.exception.BlockErrorCode.SELF_BLOCK;

public class SelfBlockException extends AbstractApiException{

	public SelfBlockException() {
		super(SELF_BLOCK);
	}

}
