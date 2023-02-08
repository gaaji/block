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
import com.gaaji.block.applicationservice.BlockDeleteService;
import com.gaaji.block.applicationservice.BlockRetriveService;
import com.gaaji.block.controller.BlockDeleteController;
import com.gaaji.block.controller.BlockRetriveController;
import com.gaaji.block.controller.dto.BlockedUserRequest;

@WebMvcTest(controllers = BlockRetriveController.class)
public class BlockRetriveControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BlockRetriveService blockRetriveService;

    @InjectMocks
    public BlockRetriveController blockRetriveController;

    @Test
    void 차단이용자_조회() throws Exception {
        //given

        mockMvc.perform(MockMvcRequestBuilders.get("/block")
                        .header(HttpHeaders.AUTHORIZATION, "authId")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
        //when

        //then

    }
}
