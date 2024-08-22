package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Basket;
import org.example.util.FilePathUtil;
import org.example.util.JsonUtil;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BasketService  {

    public void add(Basket basket){
        List<Basket> baskets = readJson();
        basket.setId(UUID.randomUUID());
        baskets.add(basket);
        writeJson(baskets);
    }

    public List<Basket> basketList(){
        return readJson();
    }

    public void removeProductFromBasket(UUID basketId) {
        List<Basket> baskets = readJson();
        baskets = baskets.stream()
                .filter(basket -> !basket.getId().equals(basketId))
                .collect(Collectors.toList());
        writeJson(baskets);
    }

    public List<Basket> getUserBasket(UUID userId) {
        return readJson().stream()
                .filter(basket -> basket.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    private List<Basket> readJson(){
        return JsonUtil.readGson(FilePathUtil.getBasket(), new TypeReference<>() {});
    }

    private void writeJson(List<Basket> baskets){
        JsonUtil.writeGson(baskets,FilePathUtil.getBasket());
    }

}
