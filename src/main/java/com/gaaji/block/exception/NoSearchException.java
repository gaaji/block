package com.gaaji.block.exception;

import static com.gaaji.block.exception.BlockErrorCode.NO_SEARCH;;

public class NoSearchException extends AbstractApiException{

	public NoSearchException() {
		super(NO_SEARCH);
	}

}
