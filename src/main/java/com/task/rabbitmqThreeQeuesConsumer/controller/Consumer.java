package com.task.rabbitmqThreeQeuesConsumer.controller;
import com.task.rabbitmqThreeQeuesConsumer.model.ProcessRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer  {


    @Autowired
    private ProcessRequest  processRequest;



    //accept the message from producer
    @RabbitListener(queues = "highMt")
    public void receive(int message)  {


            processRequest.getDataA(message);


            //log.info("message recieved from QUEUE A->{}", message);


        }


    //accept the message from producer
    @RabbitListener(queues = "lowMt")
    public void receiveFromB(int message) throws InterruptedException {

        processRequest.getDataB(message);




    }



}