package br.com.agrisource.promotions_service.controller;

import br.com.agrisource.promotions_service.model.Promotion;
import br.com.agrisource.promotions_service.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @PostMapping
    public Promotion addPromotion(@RequestBody Promotion promotion) {
        return promotionService.savePromotion(promotion);
    }

    @GetMapping("/")
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @GetMapping("/{id}")
    public Optional<Promotion> getPromotionById(@PathVariable Long id) {
        return promotionService.getPromotionById(id);
    }

    @GetMapping("/code/{code}")
    public Optional<Promotion> getPromotionByCode(@PathVariable String code) {
        return promotionService.getPromotionByCode(code);
    }

    @PutMapping("/{id}")
    public Promotion updatePromotion(@PathVariable Long id, @RequestBody Promotion promotion) {
        return promotionService.updatePromotion(id, promotion);
    }

    @DeleteMapping("/{id}")
    public void deletePromotion(@PathVariable Long id) {
        promotionService.deletePromotion(id);
    }
}
