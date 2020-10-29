package dk.lundogbendsen.springbootex18scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

public class ScheduledService {
    @Scheduled(cron = "*/10 * * * * *")
    public void myCronScheduledMethod() {
        System.out.println("CronTime is " + new Date());
    }

    @Scheduled(fixedRate = 10000)
    public void myRateScheduledMethod() {
        System.out.println("RateTime is " + new Date());
    }

}
