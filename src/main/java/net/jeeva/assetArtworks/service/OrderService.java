package net.jeeva.assetArtworks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.jeeva.assetArtworks.model.Order;
import net.jeeva.assetArtworks.web.dto.AllOrdersDto;
import net.jeeva.assetArtworks.web.dto.OrderDto;

@Service
public interface OrderService {
	
	public void saveOrder(OrderDto orderDto);
	public void statusUpdate(Long id,String status);
	public List<Order> viewAllByUser(String email);// for the users to see my-orders
	public List<AllOrdersDto> viewAllOrders();	// for the admin to see all-orders 
}
