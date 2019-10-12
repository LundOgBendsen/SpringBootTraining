package dk.lundogbendsen.springboot.ex.springbootex13aop.service;

import dk.lundogbendsen.springboot.ex.springbootex13aop.aop.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @LogExecutionTime
    public void randomPause(int maxMillis) {
        doPause(maxMillis);
    }

    @LogExecutionTime
    public void doPause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
