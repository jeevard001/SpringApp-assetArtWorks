package net.jeeva.assetArtworks.web;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import net.jeeva.assetArtworks.model.Image1;
import net.jeeva.assetArtworks.model.Image2;
import net.jeeva.assetArtworks.model.User;
import net.jeeva.assetArtworks.service.Image1Service;
import net.jeeva.assetArtworks.service.Image2Service;

@Controller
public class ImageController {
	
	@Autowired
	private Image1Service image1Service;
	
	@Autowired
	private Image2Service image2Service;
	
	 // display image1
    @GetMapping("/display1")
    public ResponseEntity<byte[]> displayImage1(@RequestParam("id") long id) throws IOException, SQLException
    {
        Image1 image = image1Service.viewById(id);
        byte [] imageBytes = null;
        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
    
    // display image2
    @GetMapping("/display2")
    public ResponseEntity<byte[]> displayImage2(@RequestParam("id") long id) throws IOException, SQLException
    {
        Image2 image = image2Service.viewById(id);
        byte [] imageBytes = null;
        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
    
    //delete from image1
    @GetMapping("/delete1")
    @ResponseBody
    public String deleteImage1(@RequestParam("id") long id)throws IOException, SQLException
    {
    	image1Service.deleteById(id);
    	return "deleted";
    }
    
  //delete from image2
    @GetMapping("/delete2")
    @ResponseBody
    public String deleteImage2(@RequestParam("id") long id)throws IOException, SQLException
    {
    	image2Service.deleteById(id);
    	return "deleted";
    }

    // view All images(1&2)
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home");
        List<Image1> image1List = image1Service.viewAll();
        List<Image2> image2List = image2Service.viewAll();
        mv.addObject("image1List", image1List);
        mv.addObject("image2List", image2List);
        return mv;
    }

    // add1 image - get
    @GetMapping("/add1")
    public ModelAndView addImage1(){
        return new ModelAndView("addimage1");
    }
    
    // add2 image - get
    @GetMapping("/add2")
    public ModelAndView addImage2(){
        return new ModelAndView("addimage2");
    }

    // add1 image - post
    @PostMapping("/add1")
    public String addImage1Post(@RequestParam("title") String title,@RequestParam("about") String about,HttpServletRequest request,@RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Image1 image = new Image1();
        image.setImage(blob);
        image.setTitle(title);
        image.setAbout(about);
        image1Service.create(image);
        return "redirect:/home";
    }
    
 // add2 image - post
    @PostMapping("/add2")
    public String addImage2Post(@RequestParam("price") String price,@RequestParam("title") String title,@RequestParam("about") String about,HttpServletRequest request,@RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Image2 image = new Image2();
        image.setImage(blob);
        image.setTitle(title);
        image.setAbout(about);
        image.setPrice(price);
        image2Service.create(image);
        return "redirect:/home";
    }
    
}
