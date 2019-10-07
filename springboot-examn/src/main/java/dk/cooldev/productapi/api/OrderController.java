package dk.cooldev.productapi.api;

import dk.cooldev.productapi.api.dto.CreateOrderRequest;
import dk.cooldev.productapi.api.dto.OrderDTO;
import dk.cooldev.productapi.api.dto.OrderLineDTO;
import dk.cooldev.productapi.model.Order;
import dk.cooldev.productapi.model.OrderLine;
import dk.cooldev.productapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @GetMapping
//    public Page<Order> list() {
//        return orderService.list(Pageable.unpaged());
//    }

    @GetMapping
    public Page<OrderDTO> findByPeriod(@RequestParam(value = "after", required = false) @DateTimeFormat(pattern="yyyy-MM-dd")Date d1, @RequestParam(value = "before", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date d2) {
        Page<Order> list = orderService.list(d1, d2, Pageable.unpaged());
        List<OrderDTO> dtoList = toDto(list);
        Page<OrderDTO> orderDTOS = new PageImpl<>(dtoList);
        return orderDTOS;
    }

    private List<OrderDTO> toDto(Page<Order> list) {
        List<OrderDTO> orderDtos = list.stream().map(order -> toDto(order)).collect(Collectors.toList());
        return orderDtos;
    }

    private OrderDTO toDto(Order order) {
        OrderDTO orderDTO = OrderDTO.builder().orderId(order.getId()).email(order.getEmail()).orderSum(order.getSum()).orderLines(toDto(order.getOrderLines())).orderDate(order.getCreatedAt()).build();
        return orderDTO;
    }

    @GetMapping("/{orderId}")
    public OrderDTO get(@PathVariable Long orderId) {
        return toDto(orderService.getOrFail(orderId));
    }

    @PostMapping()
    public OrderDTO create(@RequestBody CreateOrderRequest createOrderRequest) {
        List<OrderLine> orderLines = createOrderRequest.getProducts().entrySet().stream().map(entry -> orderService.makeOrderLine(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        Order order = orderService.createOrder(createOrderRequest.getEmail(), orderLines);
        return toDto(order);
    }

    private List<OrderLineDTO> toDto(List<OrderLine> orderLines) {
        return orderLines.stream().map(this::toDto).collect(Collectors.toList());
    }

    private OrderLineDTO toDto(OrderLine orderLine) {
        return OrderLineDTO.builder().productName(orderLine.getProductName()).productPrice(orderLine.getProductPrice()).amount(orderLine.getAmount()).orderLinePrice(orderLine.getOrderlineSum()).build();
    }

    @PutMapping()
    public OrderDTO update(@RequestBody Order update) {
        return toDto(orderService.update(update));
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable Long orderId) {
        orderService.delete(orderId);
    }


}
