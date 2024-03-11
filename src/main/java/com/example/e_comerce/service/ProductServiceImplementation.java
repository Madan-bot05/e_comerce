package com.example.e_comerce.service;

import com.example.e_comerce.exception.ProductException;
import com.example.e_comerce.model.Category;
import com.example.e_comerce.model.Product;
import com.example.e_comerce.repository.CategoryRepository;
import com.example.e_comerce.repository.ProductRepository;
import com.example.e_comerce.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductServiceImplementation implements  ProductService{

    private ProductRepository productRepository;

    private UserService userService;

    private CategoryRepository categoryRepository;

    public ProductServiceImplementation(ProductRepository productRepository,UserService userService,  CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(CreateProductRequest req) {

//        1st level
//        Category topLevel=categoryRepository.findByName(req.getTopLevelCategory());
//
//        if(topLevel==null) {
//
//            Category topLavelCategory=new Category();
//            topLavelCategory.setName(req.getTopLevelCategory());
//            topLavelCategory.setLevel(1);
//
//            topLevel= categoryRepository.save(topLavelCategory);
//        }
//
//        Category secondLevel=categoryRepository.
//                findByNameAndParent(req.getSecondLevelCategory(),topLevel.getName());
//        if(secondLevel==null) {
//
//            Category secondLavelCategory=new Category();
//            secondLavelCategory.setName(req.getSecondLevelCategory());
//            secondLavelCategory.setParentCategory(topLevel);
//            secondLavelCategory.setLevel(2);
//
//            secondLevel= categoryRepository.save(secondLavelCategory);
//        }
//
//        Category thirdLevel=categoryRepository.findByNameAndParent(req.getThirdLevelCategory(),secondLevel.getName());
//        if(thirdLevel==null) {
//
//            Category thirdLavelCategory=new Category();
//            thirdLavelCategory.setName(req.getThirdLevelCategory());
//            thirdLavelCategory.setParentCategory(secondLevel);
//            thirdLavelCategory.setLevel(3);
//
//            thirdLevel=categoryRepository.save(thirdLavelCategory);
//        }




//        Category topLevel = categoryRepository.findByName(req.getTopLevelCategory());
//
//        if (topLevel == null) {
//            topLevel = new Category();
//            topLevel.setName(req.getTopLevelCategory());
//            topLevel.setLevel(1);
//
//            topLevel = categoryRepository.save(topLevel);
//        }
//
//        Category secondLevel = categoryRepository.findByNameAndParent(req.getSecondLevelCategory(), String.valueOf(topLevel));
//        if (secondLevel == null) {
//            secondLevel = new Category();
//            secondLevel.setName(req.getSecondLevelCategory());
//            secondLevel.setParentCategory(topLevel);
//            secondLevel.setLevel(2);
//
//            secondLevel = categoryRepository.save(secondLevel);
//        }
//
//        Category thirdLevel = categoryRepository.findByNameAndParent(req.getThirdLevelCategory(), String.valueOf(secondLevel));
//        if (thirdLevel == null) {
//            thirdLevel = new Category();
//            thirdLevel.setName(req.getThirdLevelCategory());
//            thirdLevel.setParentCategory(secondLevel);
//            thirdLevel.setLevel(3);
//
//            thirdLevel = categoryRepository.save(thirdLevel);
//        }



        Product product=new Product();
        product.setTitle(req.getTitle());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        product.setDiscountedPrice(req.getDicountedPrice());
        product.setDiscountedPercent(req.getDicountPercent());
        product.setBrand(req.getBrand());
        product.setColor(req.getColor());
        product.setSizes(req.getSize());
        product.setImageUrl(req.getImageUrl());
        product.setQuantity(req.getQuantity());
        product.setCategory( req.getTopLevelCategory());
        product.setCategory(req.getSecondLevelCategory());
        product.setCategory(req.getThirdLevelCategory());
//        product.setCategory( thirdLevel);
//        product.setCategory(topLevel); // Set the top level category
//        product.setCategory(secondLevel); // Set the second level category
//        product.setCategory(thirdLevel); // Set the third level category
        product.setCreatedAt(LocalDateTime.now());


        Product savedProduct=productRepository.save(product);
        System.out.println("products - "+product);
        return  savedProduct;
    }


    @Override
    public String deleteProduct(Long ProductId) throws ProductException {
        Product product=findProductById(ProductId);
        product.getSizes().clear();
        productRepository.delete(product);
        return "Product Deleted Sucessfully";
    }


    @Override
    public Product updateProduct(Long productId, Product req) throws ProductException {
        Product product=findProductById(productId);

        if(req.getQuantity()!=0){
            product.setQuantity(req.getQuantity());
        }
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long id) throws ProductException {
        Optional<Product> opt= productRepository.findById(id);

        if(opt.isPresent()){
            return opt.get();
        }
        throw  new ProductException("Product Not Found With Id"+id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> recentlyAddedProduct() {
        return productRepository.findTop10ByOrderByCreatedAtDesc();
    }

    @Override
    public List<Product> searchProduct(String query) {
        return null;
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        return null;

    }

    @Override
    public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);

        List<Product> products=productRepository.filterProducts(category,minPrice,maxPrice, String.valueOf(minDiscount),sort);
        if (!colors.isEmpty()){
            products=products.stream().filter(p-> colors.stream().anyMatch(c->c.equalsIgnoreCase(p.getColor())))
                    .collect(Collectors.toList());
        } else if
        (stock!=null){
            if (stock.equals("in_stock")){
                products=products.stream().filter(p->p.getQuantity()<1).collect(Collectors.toList());
            }
        }

        int startIndex=(int) pageable.getOffset();
        int endIndex= Math.min(startIndex + pageable.getPageSize(),products.size());

        List<Product> pageContext=products.subList(startIndex, endIndex);
        Page<Product> filteredProducts =new PageImpl<>(pageContext,pageable,products.size());
        return filteredProducts;
    }
}
