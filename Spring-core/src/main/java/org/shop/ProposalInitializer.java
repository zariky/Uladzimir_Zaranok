package org.shop;

import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.common.Products;
import org.shop.data.Product;
import org.shop.data.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalInitializer {
    
	@Autowired
    private ProductService productService;
    
	@Autowired
    private ProposalService proposalService;
    
	@Autowired
    private SellerService sellerService;
	
    public void initProposals() {
        Seller amazon = sellerService.getSellerById((long) 1);
        Seller samsung = sellerService.getSellerById((long) 2);
        
        Product galaxyTab = productService.getProductsByName(Products.SAMSUNG_GALAXY_TAB).get(0);
        Product kindleFire = productService.getProductsByName(Products.KINDLE_FIRE).get(0);
        Product kindleTouch = productService.getProductsByName(Products.KINDLE_TOUCH).get(0);
        Product galaxyAce = productService.getProductsByName(Products.SAMSUNG_GALAXY_ACE).get(0);
        
        //Samsung
        proposalService.createProposal(samsung.getId(), galaxyAce.getId(), 250.0);
        proposalService.createProposal(samsung.getId(), galaxyTab.getId(), 500.0);
        
        //Amazon
        proposalService.createProposal(amazon.getId(), kindleFire.getId(), 199.0);
        proposalService.createProposal(amazon.getId(), kindleTouch.getId(), 99.0);
    }
}
