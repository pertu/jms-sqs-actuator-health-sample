package com.github.pertu.boot;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfiguration {

    @Bean
    public SQSConnectionFactory sqsConnectionFactory() {
        int whatever = 123;
        var providerCfg = new ProviderConfiguration()
                .withNumberOfMessagesToPrefetch(whatever);

        AmazonSQS sqsClient = createBrokenSqsClient();

        return new SQSConnectionFactory(providerCfg, sqsClient);
    }

    private AmazonSQS createBrokenSqsClient() {
        String invalidSqsEndpointUri = "http://example.com:1234";
        String invalidSqsRegion = "fake-aws-region";
        var invalidEndpoint = new EndpointConfiguration(
                invalidSqsEndpointUri,
                invalidSqsRegion);

        return AmazonSQSClientBuilder.standard()
                .withEndpointConfiguration(invalidEndpoint)
                .build();
    }
}
