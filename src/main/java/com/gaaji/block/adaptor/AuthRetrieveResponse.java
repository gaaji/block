package com.gaaji.block.adaptor;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRetrieveResponse {

    private String authId;
    private String nickname;
    private String pictureUrl;

}
