package net.jeeva.assetArtworks.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.jeeva.assetArtworks.model.Order;
import net.jeeva.assetArtworks.model.User;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByU(User u);
	
}
