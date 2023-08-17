package net.jeeva.assetArtworks.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.jeeva.assetArtworks.model.Order;
import net.jeeva.assetArtworks.model.User;
import net.jeeva.assetArtworks.web.dto.AllOrdersDto;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByU(User u);

	@Query("SELECT new net.jeeva.assetArtworks.web.dto.AllOrdersDto(o.id , o.date , o.imageId , o.type , o.title , o.about , o.phno , "
			+ "o.address , o.status , o.price , u.id , u.name , u.email) FROM Order o JOIN o.u u ORDER BY o.date DESC")
	List<AllOrdersDto> findAllOrders();				
	
	
}
