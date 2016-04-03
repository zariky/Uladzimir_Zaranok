package org.shop.repository;

import java.util.List;

import org.shop.data.Seller;

public interface SellerRepository {
        
    void createOrUpdateSeller(Seller seller);
    
    List<Seller> getSellers();
    
    Seller getSellerById(Long sellerId);
}
