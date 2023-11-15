package com.detabase.oneToMany;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class ExecuterService {

    public static void main(String[] args) {
        ExecutorService executerService = Executors.newFixedThreadPool(10); //1st way   // is main ap limit dy sakty ho k itny task run hon mean itny thread create hon
        ExecutorService executerService1 = Executors.newCachedThreadPool(); //2nd way    // it has a space to run only one thread or task
        ExecutorService executerService3 = Executors.newSingleThreadExecutor(); //4th way    // is main mention ni kerna hota or yeh aik aik ker k task ko laita hy

//        ScheduledExecutorService executerService2 = Executors.newScheduledThreadPool(10);  // 3rd way  // is mian three 3 method hain
//        executerService2.schedule(new Task(),10, TimeUnit.SECONDS);   // 1st method  // run after 10 second
//        executerService2.scheduleAtFixedRate(new Task(),15,10, TimeUnit.SECONDS);   // 2nd method // run repeatedly every 10 second  and first time it will take 15 seccond and next it will take 10 second
//        executerService2.scheduleWithFixedDelay(new Task(),15,10, TimeUnit.SECONDS);   // 3rd method // run repeatedly after 10 second after previous task complete



        for (int i=0;i<100;i++){
            executerService.execute(new Task());

        }
    }

    public static class Task implements Runnable{
        public void run(){
            System.out.println("My real problem is you : ");
        }
    }
}
