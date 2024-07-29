package br.com.agrisource.promotions_service.service;

import br.com.agrisource.promotions_service.model.Promotion;
import br.com.agrisource.promotions_service.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public Promotion savePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Optional<Promotion> getPromotionById(Long id) {
        return promotionRepository.findById(id);
    }

    public Optional<Promotion> getPromotionByCode(String code) {
        return promotionRepository.findByCode(code);
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

    public Promotion updatePromotion(Long id, Promotion promotionDetails) {
        return promotionRepository.findById(id).map(promotion -> {
            promotion.setCode(promotionDetails.getCode());
            promotion.setDiscount(promotionDetails.getDiscount());
            promotion.setStartDate(promotionDetails.getStartDate());
            promotion.setEndDate(promotionDetails.getEndDate());
            promotion.setDescription(promotionDetails.getDescription());
            return promotionRepository.save(promotion);
        }).orElseThrow(() -> new RuntimeException("Promotion not found with id " + id));
    }
}
