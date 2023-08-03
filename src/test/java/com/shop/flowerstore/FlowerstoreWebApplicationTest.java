package com.shop.flowerstore;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.flowerstore.controller.StoreController;
import com.shop.flowerstore.model.BouquetFlower;
import com.shop.flowerstore.model.BouquetFlowerType;
import com.shop.flowerstore.service.ItemManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FlowerstoreWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemManager manager;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    public void getAllFlowersTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/flowers")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    @Test
    @WithMockUser
    public void createEmployeeAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/flowers/addFlower")
                        .content(asJsonString(new BouquetFlower(BouquetFlowerType.ROSE, 55, "special", "blue")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

