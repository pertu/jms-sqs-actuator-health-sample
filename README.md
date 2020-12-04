# jms-sqs-actuator-health-sample

Sample for [`JmsHealthIndicator`](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-actuator/src/main/java/org/springframework/boot/actuate/jms/JmsHealthIndicator.java) & AWS SQS JMS provider.  
`JmsHealthIndicator` returns `UP` even if SQS is not really OK.  