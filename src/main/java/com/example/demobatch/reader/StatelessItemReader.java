package com.example.demobatch.reader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@NoArgsConstructor
@Data
public class StatelessItemReader implements ItemReader<String> {

    private Iterator<String> data;

    public StatelessItemReader(Iterator<String> data) {
        this.data = data;
    }

    @Override
    public String read() throws Exception {
        if (this.data.hasNext()) {
            return this.data.next();
        }
        return null;
    }
}
