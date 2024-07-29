package br.com.agrisource.logistics_service.service;

import br.com.agrisource.logistics_service.model.Delivery;
import br.com.agrisource.logistics_service.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery saveDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }

    public List<Delivery> getDeliveriesByOrderId(Long orderId) {
        return deliveryRepository.findByOrderId(orderId);
    }

    public List<Delivery> getDeliveriesByDeliveryServiceId(Long deliveryServiceId) {
        return deliveryRepository.findByDeliveryServiceId(deliveryServiceId);
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

    public Delivery updateDelivery(Long id, Delivery deliveryDetails) {
        return deliveryRepository.findById(id).map(delivery -> {
            delivery.setOrderId(deliveryDetails.getOrderId());
            delivery.setDeliveryServiceId(deliveryDetails.getDeliveryServiceId());
            delivery.setDeliveryStatus(deliveryDetails.getDeliveryStatus());
            delivery.setEstimatedDeliveryDate(deliveryDetails.getEstimatedDeliveryDate());
            delivery.setTrackingNumber(deliveryDetails.getTrackingNumber());
            return deliveryRepository.save(delivery);
        }).orElseThrow(() -> new RuntimeException("Delivery not found with id " + id));
    }
}
