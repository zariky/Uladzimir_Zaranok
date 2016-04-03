package org.shop.repository.map;

import java.util.List;

import org.apache.commons.collections.Predicate;
import org.shop.data.Order;
import org.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("orderRepository")
public class OrderMapRepository extends AbstractMapRepository<Order> implements OrderRepository {

	@Value("${repository.order.pk}")
    public void setSequence(long sequence) {
        super.sequence = sequence;
    }
    
    @Override
    public Order getOrderById(Long id) {
        return get(id);
    }
    
    @Override
    public Long createOrder(Order order) {
        return create(order);
    }
    
    @Override
    public void updateOrder(Order order) {
        update(order);
    }
    
    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return select(new OrderByUserPredicate(userId));
    }

    
    private class OrderByUserPredicate implements Predicate {
        
        private Long userId;
        
        private OrderByUserPredicate(Long userId) {
            super();
            this.userId = userId;
        }
        
        @Override
        public boolean evaluate(Object input) {
            if (input instanceof Order) {
                Order order = (Order)input;
                
                return userId.equals(order.getUser().getId());
            }
            
            return false;
        }
    }
}
