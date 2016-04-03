package org.shop.api.impl;

import java.util.List;

import org.shop.api.SellerService;
import org.shop.data.Seller;
import org.shop.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
    private SellerRepository repository;

    @Override
    public List<Seller> getSellers() {
        return repository.getSellers();
    }
    
    @Override
    public Seller getSellerById(Long sellerId) {
        return repository.getSellerById(sellerId);
    }
    
    @Override
    public void importSellers(List<Seller> sellers) {
        for (Seller seller : sellers) {
            repository.createOrUpdateSeller(seller);
        }
    }
}
