package com.simon.subwaydating.engine.util;

import org.springframework.context.ApplicationContext;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/10/24 16:22
 * @File : ApplicationContextUtil
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class ApplicationContextUtil {

    private ApplicationContextUtil() {
    }

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
