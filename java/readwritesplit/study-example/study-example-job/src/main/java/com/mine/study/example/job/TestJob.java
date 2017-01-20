package com.mine.study.example.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestJob
{
    private static Logger log = LoggerFactory.getLogger(TestJob.class);

    /**
     * @Description 每五秒执行测试定时任务
     * @author bm
     * @date 2016年11月13日 下午12:45:53
     * @lastModifier
     */
    @Scheduled(cron="0/5 * *  * * ? ")
    public void myTest(){  
          log.info("定时任务测试"); 
    }
}
