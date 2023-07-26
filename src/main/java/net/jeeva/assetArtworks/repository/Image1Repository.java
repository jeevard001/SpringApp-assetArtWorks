package net.jeeva.assetArtworks.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.jeeva.assetArtworks.model.Image1;

@Repository
public interface Image1Repository extends JpaRepository<Image1, Long>{

}
