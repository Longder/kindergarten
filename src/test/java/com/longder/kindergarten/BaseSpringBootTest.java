package com.longder.kindergarten;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * SpringBoot测试父类
 */
@SpringBootTest(classes = KindergartenApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseSpringBootTest {
}
