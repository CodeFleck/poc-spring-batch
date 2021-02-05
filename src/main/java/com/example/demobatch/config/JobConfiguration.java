package com.example.demobatch.config;

import com.example.demobatch.reader.StatelessItemReader;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class JobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final StatelessItemReader statelessItemReader() {
        List<String> data = new ArrayList<>(2);

        data.add("Gremio");
        data.add("Internacional");
        data.add("Juventude");

        return new StatelessItemReader(data);
    }


    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<String, String>chunk(3)
                .reader(statelessItemReader())
                .writer(list -> {
                    for (String curItem : list) {
                        System.out.println("curItem = " + curItem);
                    }
                }).build();
    }

    @Bean
    public Job interfacesJob() {
        return jobBuilderFactory.get("interfacesJob")
                .start(step1())
                .build();
    }

}
