package dk.cooldev.productapi.service;

import dk.cooldev.productapi.model.Order;
import dk.cooldev.productapi.model.OrderLine;
import dk.cooldev.productapi.model.Product;
import dk.cooldev.productapi.repositories.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    OrderService orderService;
    OrderRepository orderRepository;
    OrderLine orderLine1;
    OrderLine orderLine2;
    OrderLine orderLine3;
    OrderLine orderLine4;
    Order order1;
    Order order2;
    List<Order> orders;
    ProductService productService;

    @Before
    public void init() {
        orderRepository = mock(OrderRepository.class);
        productService = mock(ProductService.class);
        orderService = new OrderService(orderRepository,productService);
        Product p1 = Product.builder().name("p1").price(1.0).build();
        Product p2 = Product.builder().name("p2").price(2.0).build();
        Map<String, Product> productDB = new HashMap<>();
        productDB.put("p1", p1);
        productDB.put("p2", p2);

        when(productService.get(any())).then(invocationOnMock -> productDB.get(invocationOnMock.getArgument(0)));

        orderLine1 = OrderLine.builder().productName("p1").productPrice(1.0).amount(1).build();
        orderLine2 = OrderLine.builder().productName("p2").productPrice(2.0).amount(2).build();
        orderLine3 = OrderLine.builder().productName("p3").productPrice(3.0).amount(3).build();
        orderLine4 = OrderLine.builder().productName("p4").productPrice(4.0).amount(4).build();
        order1 = Order.builder().orderLines(Arrays.asList(orderLine1, orderLine2)).createdAt(getDate(2019, 1, 1)).build();
        order2 = Order.builder().orderLines(Arrays.asList(orderLine3, orderLine4)).createdAt(getDate(2019, 6, 1)).build();
        orders = Arrays.asList(order1, order2);
        when(orderRepository.findAll((Pageable) null)).thenReturn(new PageImpl<>(orders));
        when(orderRepository.findAllByCreatedAtBetween(any(), any(), any())).then(invocationOnMock -> {
            Date d1 = invocationOnMock.getArgument(0);
            Date d2 = invocationOnMock.getArgument(1);
            List<Order> collect = orders.stream().filter(order -> !order.getCreatedAt().before(d1) && !order.getCreatedAt().after(d2)).collect(Collectors.toList());
            PageImpl<Order> page = new PageImpl<>(collect, invocationOnMock.getArgument(2), collect.size());
            return page;
        });

        when(orderRepository.save(any())).then(invocationOnMock -> invocationOnMock.getArgument(0));
    }


    @Test
    public void listOrdersInPeriod() {
        Date d1 = getDate(2018, 12, 1);
        Date d2 = getDate(2020, 1, 1);
        Page<Order> list = orderService.list(d1, d2, Pageable.unpaged());
        assertEquals(2, list.getContent().size());
    }

    @Test
    public void listOrdersInPeriod2() {
        Date d1 = getDate(2019, 2, 1);
        Date d2 = getDate(2020, 1, 1);
        Page<Order> list = orderService.list(d1, d2, Pageable.unpaged());
        assertEquals(1, list.getContent().size());
    }

    @Test
    public void createOrderAndAddProducts() {
        Order o = Order.builder().createdAt(new Date()).build();
        OrderLine ol1 = orderService.makeOrderLine("p1", 1);
        // Add first orderline
        Order updated = orderService.addOrderLines(o, Arrays.asList(ol1));
        assertEquals(1.0, updated.getSum(), 0.001);
        // Add second orderline
        OrderLine ol2 = orderService.makeOrderLine("p2", 2);
        updated = orderService.addOrderLines(o, Arrays.asList(ol2));
        assertEquals(5.0, updated.getSum(), 0.001);
        //Remove first orderline
        updated = orderService.removeOrderline(updated,"p1");
        assertEquals(4.0, updated.getSum(), 0.001);

    }

    private Date getDate(int year, int month, int day) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}