package com.gaaji.block;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaaji.block.applicationservice.BlockCreateService;
import com.gaaji.block.applicationservice.BlockDeleteService;
import com.gaaji.block.controller.BlockCreateController;
import com.gaaji.block.controller.BlockDeleteControllar;
import com.gaaji.block.controller.dto.BlockedUserRequest;

@WebMvcTest(controllers = BlockDeleteControllar.class)
public class BlockUserDeleteControllarTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BlockDeleteService blockDeleteService;

    @InjectMocks
    BlockDeleteControllar blockDeleteUserControllar;

    @Test
    void 정상_차단이용자_삭제() throws Exception {
        //given

        BlockedUserRequest dto = new BlockedUserRequest("foo");

        mockMvc.perform(MockMvcRequestBuilders.delete("/block")
                        .header(HttpHeaders.AUTHORIZATION, "authId")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
        //when

        //then

    }
}
