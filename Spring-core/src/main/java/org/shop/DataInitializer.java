package org.shop;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

	@Autowired
    private SellerInitializer sellerInitializer;
    
	@Autowired
    private ProductInitializer productInitializer;
    
	@Autowired
    private ProposalInitializer proposalInitializer;
    
	@Autowired
    private UserInitializer userInitializer;

	@PostConstruct
    public void initData() {
        sellerInitializer.initSellers();
        userInitializer.initUsers();
        productInitializer.initProducts();
        proposalInitializer.initProposals();
    }
}
