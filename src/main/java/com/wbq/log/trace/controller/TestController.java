package com.wbq.log.trace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: biqin.wu
 * @Date: 2019/5/11
 * @Time: 14:53
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/m1")
    public String m1() {
        log.info("111");
        return "lol";
    }
}
