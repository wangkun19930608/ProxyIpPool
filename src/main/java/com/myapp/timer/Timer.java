package com.myapp.timer;

/**
 * Created by gaorui on 17/1/9.
 */


import com.myapp.client.Client;
import com.myapp.main.main;
import com.myapp.redis.LoadMemory;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;


public class Timer {
    final public static String job_name_1 = "task_Client";
    final public static String job_name_2 = "task2_Main";
    final public static String job_name_3 = "task3_Redis";

    public Timer() {
    }

    public static void main(String[] args) throws InterruptedException {

        //QuartzManager.addJob(job_name_1, Client.class, "0 0/10 * * * ?");
        QuartzManager.addJobT(job_name_1, Client.class);
        Thread.sleep(1000 * 60);
        QuartzManager.addJob(job_name_2, main.class, "0 0/1 * * * ?");
        QuartzManager.addJob(job_name_3, LoadMemory.class, "0 0 2 * * ?");


    }
}

