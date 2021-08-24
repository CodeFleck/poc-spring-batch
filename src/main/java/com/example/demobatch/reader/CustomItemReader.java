package com.example.demobatch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class CustomItemReader implements ItemReader<String> {

    private final Iterator<String> data;

    public CustomItemReader(List<String> data) {
        this.data = data.iterator();
    }

    @Override
    public String read() throws Exception {
        if (this.data.hasNext()) {
            return this.data.next();
        }
        return null;
    }
}
