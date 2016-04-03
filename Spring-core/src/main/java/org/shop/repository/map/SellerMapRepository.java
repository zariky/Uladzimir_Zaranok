package org.shop.repository.map;

import java.util.ArrayList;
import java.util.List;

import org.shop.data.Seller;
import org.shop.repository.SellerRepository;
import org.springframework.stereotype.Repository;

@Repository
public final class SellerMapRepository extends AbstractMapRepository<Seller> implements SellerRepository {
    
    @Override
    public void createOrUpdateSeller(Seller seller) {
        update(seller);
    }
    
    @Override
    public List<Seller> getSellers() {
        return new ArrayList<Seller>(register.values());
    }
    
    @Override
    public Seller getSellerById(Long sellerId) {
        return get(sellerId);
    }
}
