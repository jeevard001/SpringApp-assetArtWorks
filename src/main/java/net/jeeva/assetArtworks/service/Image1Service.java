package net.jeeva.assetArtworks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.jeeva.assetArtworks.model.Image1;

@Service
public interface Image1Service {

	
	public Image1 create(Image1 image1);
	public List<Image1> viewAll();
    public Image1 viewById(long id);
	public void deleteById(long id);

}
