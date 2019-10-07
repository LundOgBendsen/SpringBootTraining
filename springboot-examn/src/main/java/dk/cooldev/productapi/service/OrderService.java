package dk.cooldev.productapi.service;

import dk.cooldev.productapi.model.Order;
import dk.cooldev.productapi.model.OrderLine;
import dk.cooldev.productapi.model.Product;
import dk.cooldev.productapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;

    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public Page<Order> list(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Page<Order> list(Date d1, Date d2, Pageable pageable) {
        if (d1 == null) {
            d1 = new Date(0);
        }
        if (d2 == null) {
            d2 = new Date();
        }
        return orderRepository.findAllByCreatedAtBetween(d1, d2, pageable);
    }

    public Order createOrder(String email, List<OrderLine> orderLines) {
        Order order = Order.builder().email(email).orderLines(orderLines).createdAt(new Date()).build();
        orderLines.stream().forEach(orderLine -> orderLine.setOrder(order));
        calculateOrderSum(order);
        return orderRepository.save(order);
    }

    public Order createOrUpdate(Order order) {
        return orderRepository.save(order);
    }

    public OrderLine makeOrderLine(String productName, int count) {
        Product product = productService.get(productName);
        return OrderLine.builder().amount(count).productName(product.getName()).productPrice(product.getPrice()).orderlineSum(product.getPrice()*count).build();
    }

    public Order addOrderLines(Order order, List<OrderLine> orderLines) {
        if (order.getOrderLines() == null) {
            order.setOrderLines(new ArrayList<>());
            order.setSum(0.0);
        }
        orderLines.stream().forEach(orderLine -> orderLine.setOrder(order));
        order.getOrderLines().addAll(orderLines);
        calculateOrderSum(order);
        return orderRepository.save(order);
    }

    private void calculateOrderSum(Order order) {
        double sum = order.getOrderLines().stream().mapToDouble(OrderLine::getOrderlineSum).sum();
        order.setSum(sum);
    }

    public Order removeOrderline(Order order, String productName) {
        List<OrderLine> orderlines = order.getOrderLines().stream().filter(orderLine -> !orderLine.getProductName().equals(productName)).collect(Collectors.toList());
        order.setOrderLines(orderlines);
        calculateOrderSum(order);
        return orderRepository.save(order);
    }

    public Order getOrFail(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No order found by the given ID"));
    }

    public void delete(Long orderId) {
        Order order = getOrFail(orderId);
        orderRepository.delete(order);
    }

    public Order update(Order update) {
        Order order = getOrFail(update.getId());
        order.setOrderLines(update.getOrderLines());
        calculateOrderSum(order);
        return createOrUpdate(order);
    }
}
