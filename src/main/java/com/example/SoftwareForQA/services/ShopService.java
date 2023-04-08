package com.example.SoftwareForQA.services;

import com.example.SoftwareForQA.models.Shop;
import com.example.SoftwareForQA.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ShopService {
    private final ShopRepository shopRepository;


    @Autowired
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;

    }

    public Shop getShopById(Long id){
        return shopRepository.findById(id).orElse(null);
    }

    public List<Shop> getAllShops(){
        return shopRepository.findAll();
    }

    public Shop updateShop(Long id, Shop updShop){
        Shop oldShop = getShopById(id);
        oldShop.setCity(updShop.getCity());
        oldShop.setName(updShop.getName());
        oldShop.setHouse(updShop.getHouse());
        oldShop.setStreet(updShop.getStreet());
        oldShop.setOpeningTime(updShop.getOpeningTime());
        oldShop.setClosingTime(updShop.getClosingTime());
        return shopRepository.save(oldShop);
    }

    public Shop saveShop(Shop shop){
        return shopRepository.save(shop);
    }

    public void deleteShop(Long id){
        shopRepository.deleteById(id);
    }

    public boolean isOpen(LocalTime openingTime, LocalTime closingTime) {
        LocalTime currentTime = LocalTime.now();
        return currentTime.isAfter(openingTime) && currentTime.isBefore(closingTime);
    }

}
