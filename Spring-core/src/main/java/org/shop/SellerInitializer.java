package org.shop;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.shop.api.SellerService;
import org.shop.data.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SellerInitializer {
	
	@Autowired
    private SellerService sellerService;
    
	@Resource(name = "sellersMap")
    private Map<Long, String> sellerNames = Collections.emptyMap();
	
    public void initSellers() {
        List<Seller> sellers = new LinkedList<Seller>();
        
        for (Map.Entry<Long, String> entry : sellerNames.entrySet()) {
            Seller seller = new Seller();
            seller.setId(entry.getKey());
            seller.setName(entry.getValue());
            
            sellers.add(seller);
        }
        
        sellerService.importSellers(sellers);
    }
}
