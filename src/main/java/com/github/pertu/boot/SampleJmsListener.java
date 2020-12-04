package com.github.pertu.boot;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class SampleJmsListener {

    @JmsListener(destination = "sample-queue")
    public void onMessage(Message ignored) {
        /* does not matter */
    }
}
