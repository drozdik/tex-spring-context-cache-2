package com.tex.contextcache.controller;

import com.tex.MyEventsListener;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(MyEventsListener.class)
class TestControllerConfig {

}
