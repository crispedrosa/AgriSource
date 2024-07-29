package br.com.agrisource.logistics_service.repository;

import br.com.agrisource.logistics_service.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByOrderId(Long orderId);
    List<Delivery> findByDeliveryServiceId(Long deliveryServiceId);
}
