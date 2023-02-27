package com.example.bai_tap_ve_nha.service;

import com.example.bai_tap_ve_nha.model.Product;
import com.example.bai_tap_ve_nha.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Value("${upload}")
    private String uploadPath;
    @Autowired
    private ICrudRepository iCrudRepository;
    public List<Product> findAll(){
        return  iCrudRepository.findAll();
    }
    public Product findById(long id){
        Product product= iCrudRepository.findById(id).orElse(null);
    return product;
    }
    public void save(Product product){
        product.setImagePath(getFileName(product));
        iCrudRepository.save(product);
    }

    private String getFileName(Product product) {
        MultipartFile image = product.getImage();
        String fileName = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(), new File(uploadPath + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileName;
    }
    public void delete(Long id){
        iCrudRepository.delete(findById(id));
    }

}
