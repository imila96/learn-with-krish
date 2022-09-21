package net.javaguides.scheduleservice.kafka;


        import net.javaguides.basedomains.dto.Order;
        import net.javaguides.basedomains.dto.OrderEvent;
        import net.javaguides.basedomains.dto.Stock;
        import net.javaguides.basedomains.dto.StockEvent;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.kafka.annotation.KafkaListener;
        import org.springframework.stereotype.Service;

        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;
        import java.util.Random;


@Service

public class StockConsumer {

    static String orderId;
    static String fuelType;
    static int qty;

    static LocalDateTime dateTime;
    static LocalDate date;

    private ScheduleProducer scheduleProducer;

    public StockConsumer(ScheduleProducer scheduleProducer) {
        this.scheduleProducer = scheduleProducer;
    }



    private static final Logger LOGGER = LoggerFactory.getLogger(StockConsumer.class);



    @KafkaListener(
            topics = "${spring.kafka.topic.name1}" ,
            groupId = "${spring.kafka.consumer.group-id1}")

    public void consume(OrderEvent event){

        LOGGER.info(String.format("Stock event received in schedule service => %s",event.toString()));

        Order order1=new Order();
        order1=event.order;

        String SId=order1.getOrderId();
        String SType=order1.getFuelType();
        String SStatus=order1.getStatus();
        int SQty=order1.getQty();

       LocalDateTime dateTime=order1.getDateTime();
       LocalDate date=order1.getDate();

        String SOQty=String.valueOf(SQty);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedLocalDateTime = dateTime.format(dateTimeFormatter);


        Random random = new Random();
        int randomAmountOfDays = random.nextInt(5 - 0 + 1) + 0;
        LocalDateTime futureLocalDateTime = dateTime.plusDays(randomAmountOfDays);

        String formattedFutureLocalDateTime = futureLocalDateTime.format(
                dateTimeFormatter);





        LOGGER.info("this is schedule consumer");
        LOGGER.info(SId);
        LOGGER.info(SType);
        LOGGER.info(SOQty);
        LOGGER.info(SStatus);
        LOGGER.info(dateTime.toString());
        LOGGER.info(date.toString());


        order1.setDateTime(futureLocalDateTime);
        order1.setDate(futureLocalDateTime.toLocalDate());

        event.setOrder(order1);

        LOGGER.info("Scheduled date for order Id : "+SId+" is "+formattedFutureLocalDateTime.toString());

        scheduleProducer.sendMessage(event);




    }


}
