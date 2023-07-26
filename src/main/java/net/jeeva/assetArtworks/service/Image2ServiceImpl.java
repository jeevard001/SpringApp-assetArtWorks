package net.jeeva.assetArtworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jeeva.assetArtworks.model.Image2;
import net.jeeva.assetArtworks.repository.Image2Repository;

@Service
public class Image2ServiceImpl implements Image2Service{

	@Autowired
	private Image2Repository repo;
	
	@Override
	public Image2 create(Image2 image2) {
		return repo.save(image2);
	}	

	@Override
	public List<Image2> viewAll() {
		return (List<Image2>) repo.findAll();
	}

	@Override
	public Image2 viewById(long id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}
}
