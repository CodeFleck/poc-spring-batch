package com.example.demobatch.config;

import com.example.demobatch.processor.CustomeItemProcessor;
import com.example.demobatch.reader.CustomItemReader;
import com.example.demobatch.writer.CustomItemWriter;
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

    @Bean
    public Job interfacesJob() {
        return jobBuilderFactory.get("Job1")
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<String, String>chunk(3)
                .reader(customItemReader())
                .processor(customProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    CustomItemWriter itemWriter() {
        return new CustomItemWriter();
    }

    @Bean
    CustomeItemProcessor customProcessor() {
        return new CustomeItemProcessor();
    }

    CustomItemReader customItemReader() {
        List<String> data = new ArrayList<>();

        data.add("Gremio");
        data.add("Internacional");
        data.add("Juventude");

        return new CustomItemReader(data);
    }

}
