package net.yorksolutions.teamproject.services;


import net.yorksolutions.teamproject.dto.NewProductRequestDTO;
import net.yorksolutions.teamproject.dto.UpdateProductRequestDTO;
import net.yorksolutions.teamproject.models.Product;
import net.yorksolutions.teamproject.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product create(NewProductRequestDTO requestDTO){
        try {
            return this.productRepository.save(
                    new Product(requestDTO.name, requestDTO.description, requestDTO.imgUrl, requestDTO.price, requestDTO.sale,
                            requestDTO.category, requestDTO.discontinued, requestDTO.discount));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//    } catch (RuntimeException exception) {
//        throw new ResponseStatusException(HttpStatus.CONFLICT);
//    }
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void delete(Long productId){
        this.productRepository.deleteById(productId);
    }

    public Product update(UpdateProductRequestDTO requestDTO){
        Optional<Product> productOpt = this.productRepository.findById(requestDTO.id);
        if(productOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Product product = productOpt.get();
        product.setName(requestDTO.name);
        product.setDescription(requestDTO.description);
        product.setImgUrl(requestDTO.imgUrl);
        product.setPrice(requestDTO.price);
        product.setSale(requestDTO.sale);
        product.setCategory(requestDTO.category);
        product.setDiscontinued(requestDTO.discontinued);
        product.setDiscount(requestDTO.discount);

        return this.productRepository.save(product);
    }
    /*public Product saveProductDiscount(Long id, int discount) {
        Product p = new Product();
        p = productRepository.findById(id).orElse(null);
        assert p != null;
        if(p.getDiscount() == null) {
            product. c = new Coupon();
            c.setDiscount(discount);
            p.setDiscount(c);
        }
        else {
            p.getDiscount().setDiscount(discount);
        }
        return this.productRepository.save(p);
    }*/


    //for testing
    public Product test(NewProductRequestDTO requestDTO){
        try {
            this.productRepository.save(
                    new Product(requestDTO.name, requestDTO.description, requestDTO.imgUrl, requestDTO.price, requestDTO.sale,
                            requestDTO.category, requestDTO.discontinued, requestDTO.discount)
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
