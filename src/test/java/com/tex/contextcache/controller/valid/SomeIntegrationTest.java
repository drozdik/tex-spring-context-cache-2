package com.tex.contextcache.controller.valid;

import com.tex.MyEventsListener;
import com.tex.contextcache.controller.ControllerIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class SomeIntegrationTest extends ControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @TestConfiguration
    @Import(MyEventsListener.class)
    static class TestControllerConfig{

    }

    @Test
    void name() {
        assertThat(true).isTrue();
    }
}
