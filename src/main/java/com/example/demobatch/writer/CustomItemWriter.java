package com.example.demobatch.writer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomItemWriter implements org.springframework.batch.item.ItemWriter {

    @Override
    public void write(List list) throws Exception {
        list.forEach(System.out::println);
    }
}
