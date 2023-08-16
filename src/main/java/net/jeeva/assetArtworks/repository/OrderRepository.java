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
	
	
//	@Query("SELECT new net.jeeva.assetArtworks.web.dto.AllOrdersDto(o.type , u.email) FROM Order o JOIN o.u u")
//	List<AllOrdersDto> findAllOrders();
	
	
	//long id, Date date, String type, String email
//	@Query("SELECT new net.jeeva.assetArtworks.web.dto.AllOrdersDto(o.id , o.date , o.type , u.email) FROM Order o JOIN o.u u")
//	List<AllOrdersDto> findAllOrders();
	
	
	//long id, Date date, String type, long userId, String email
//	@Query("SELECT new net.jeeva.assetArtworks.web.dto.AllOrdersDto(o.id , o.date , o.type , u.id , u.email) FROM Order o JOIN o.u u")
//	List<AllOrdersDto> findAllOrders();
	
		//long id, Date date, long imageId, String type, String title, String about, String phno,
		//String address, String status, String price, long userId, String name, String email
	@Query("SELECT new net.jeeva.assetArtworks.web.dto.AllOrdersDto(o.id , o.date , o.imageId , o.type , o.title , o.about , o.phno , "
			+ "o.address , o.status , o.price , u.id , u.name , u.email) FROM Order o JOIN o.u u ORDER BY o.date DESC")
	List<AllOrdersDto> findAllOrders();				 //test success  and sorted according to the date
	
	
}
