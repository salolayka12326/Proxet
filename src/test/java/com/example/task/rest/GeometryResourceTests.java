package com.example.task.rest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link GeometryResource} REST controller.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class GeometryResourceTests {


    @Autowired
    private MockMvc restGeometryMockMvc;

    @Test
    public void testGetCircumference() throws Exception {
        restGeometryMockMvc.perform(get("/api/circle/length").param("radius", "54"))
                .andExpect(content().string("339.29200658769764"));
    }

    @Test
    public void testGetCircleArea() throws Exception {
        restGeometryMockMvc.perform(get("/api/circle/area").param("radius", "54"))
                .andExpect(content().string("9160.884177867836"));
    }

    @Test
    public void testGetRectanglePerimeter() throws Exception {
        restGeometryMockMvc.perform(get("/api/rectangle/perimeter").param("a", "2").param("b", "2"))
                .andExpect(content().string("8.0"));
    }

    @Test
    public void testGetRectangleArea() throws Exception {
        restGeometryMockMvc.perform(get("/api/rectangle/area").param("a", "2").param("b", "2"))
                .andExpect(content().string("4.0"));
    }

    @Test
    public void testGetSquarePerimeter() throws Exception {
        restGeometryMockMvc.perform(get("/api/square/perimeter").param("side", "1"))
               .andExpect(content().string("4.0"));
    }

    @Test
    public void testGetSquareArea() throws Exception {
       restGeometryMockMvc.perform(get("/api/square/area").param("side", "12"))
                .andExpect(content().string("144.0"));
    }

    @Test
    public void testGetTrianglePerimeter() throws Exception {
        restGeometryMockMvc.perform(get("/api/triangle/perimeter").param("a", "3").param("b", "4").param("c", "5"))
                .andExpect(content().string("12.0"));
    }

    @Test
    public void testGetTriangleArea() throws Exception {
        restGeometryMockMvc.perform(get("/api/triangle/area").param("a", "3").param("b", "4").param("c", "5"))
                .andExpect(content().string("6.0"));
    }
}
