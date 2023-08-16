package net.jeeva.assetArtworks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.jeeva.assetArtworks.model.Order;
import net.jeeva.assetArtworks.web.dto.AllOrdersDto;
import net.jeeva.assetArtworks.web.dto.OrderDto;

@Service
public interface OrderService {
	
	public void saveOrder(OrderDto orderDto);
	
	//public List<Order> viewAll();  // for all orders
	public void statusUpdate(Long id,String status);
	public List<Order> viewAllByUser(String email);// for the user-my orders
	
	//test for the new allOrders
	public List<AllOrdersDto> viewAllOrders();	// for all orders -  test success 
}
