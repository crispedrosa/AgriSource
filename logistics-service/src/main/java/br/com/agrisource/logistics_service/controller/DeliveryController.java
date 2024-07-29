package br.com.agrisource.logistics_service.controller;

import br.com.agrisource.logistics_service.model.Delivery;
import br.com.agrisource.logistics_service.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public Delivery addDelivery(@RequestBody Delivery delivery) {
        return deliveryService.saveDelivery(delivery);
    }

    @GetMapping("/")
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public Optional<Delivery> getDeliveryById(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id);
    }

    @GetMapping("/order/{orderId}")
    public List<Delivery> getDeliveriesByOrderId(@PathVariable Long orderId) {
        return deliveryService.getDeliveriesByOrderId(orderId);
    }

    @GetMapping("/service/{deliveryServiceId}")
    public List<Delivery> getDeliveriesByDeliveryServiceId(@PathVariable Long deliveryServiceId) {
        return deliveryService.getDeliveriesByDeliveryServiceId(deliveryServiceId);
    }

    @PutMapping("/{id}")
    public Delivery updateDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        return deliveryService.updateDelivery(id, delivery);
    }

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
    }
}
