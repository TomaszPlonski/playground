package com.tplonski;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(Main::myTask, 0, 1, TimeUnit.SECONDS);
    }

        private static void myTask() {
            System.out.println("Running");
        }

}