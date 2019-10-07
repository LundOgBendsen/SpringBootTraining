package dk.cooldev.productapi.repositories;

import dk.cooldev.productapi.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
    Page<Order> findAllByCreatedAtBetween(Date d1, Date d2, Pageable pageable);
}
