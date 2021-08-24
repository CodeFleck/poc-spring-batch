package com.example.demobatch.processor;

import org.springframework.batch.item.ItemProcessor;

public class CustomeItemProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String s) throws Exception {
        return s.toUpperCase();
    }
}
