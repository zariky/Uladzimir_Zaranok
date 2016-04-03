package org.shop.api.impl;

import java.util.List;

import org.shop.api.ItemService;
import org.shop.data.Item;
import org.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
    
    private final ItemRepository repository;
    
    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Long createItem(Item item) {
        return repository.createItem(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        repository.deleteItem(itemId);
    }

    @Override
    public List<Item> getItemsByOrderId(Long orderId) {
        return repository.getItemsByOrderId(orderId);
    }
}
