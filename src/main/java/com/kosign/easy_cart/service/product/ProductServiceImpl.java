package com.kosign.easy_cart.service.product;

import com.kosign.easy_cart.common.api.StatusCode;
import com.kosign.easy_cart.entity.Category;
import com.kosign.easy_cart.entity.Photo;
import com.kosign.easy_cart.entity.Product;
import com.kosign.easy_cart.entity.User;
import com.kosign.easy_cart.exception.BusinessException;
import com.kosign.easy_cart.exception.EntityNotFoundException;
import com.kosign.easy_cart.payload.photo.PhotoResponse;
import com.kosign.easy_cart.payload.product.ProductMainResponse;
import com.kosign.easy_cart.payload.product.ProductRequest;
import com.kosign.easy_cart.payload.product.ProductResponse;
import com.kosign.easy_cart.payload.user.UserResponse;
import com.kosign.easy_cart.repository.CategoryRepository;
import com.kosign.easy_cart.repository.PhotoRepository;
import com.kosign.easy_cart.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PhotoRepository photoRepository;



    @Override
    public void postNewProduct(ProductRequest productRequest, String categoryName) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = categoryRepository.findByName(categoryName);
        List<Photo> photos = photoRepository.saveAll(productRequest.getPhoto());

        BigDecimal totalAmount = BigDecimal.valueOf(0);

        if (productRequest.getDiscountType()) {
            totalAmount = productRequest.getPrice().subtract(productRequest.getDiscountPrice()).divide(BigDecimal.valueOf(100), MathContext.DECIMAL128);
        } else {
            totalAmount = productRequest.getPrice().subtract(productRequest.getDiscountPrice());
        }

        if (productRequest.getDiscountPrice().compareTo(productRequest.getPrice()) > 0) {
            throw new BusinessException(StatusCode.INVALID_DISCOUNT_PRICE);
        }

        Product product = Product
                .builder()
                .user(user)
                .category(category)
                .title(productRequest.getTitle())
                .description(productRequest.getDescription())
                .status("Selling")
                .price(productRequest.getPrice())
                .totalAmount(totalAmount)
                .discountPrice(productRequest.getDiscountPrice())
                .discountType(productRequest.getDiscountType())
                .createdDate(LocalDateTime.now())
                .condition(productRequest.getCondition())
                .brand(productRequest.getBrand())
                .model(productRequest.getModel())
                .color(productRequest.getColor())
                .year(productRequest.getYear())
                .size(productRequest.getSize())
                .type(productRequest.getType())
                .isHidden(false)
                .photos(photos)
                .build();

        // Set the product object in each photo
        for (Photo photo : photos) {
            photo.setProduct(product);
        }

        productRepository.save(product);
    }

    @Override
    public Object getAllProduct(Pageable pageable) {

        Page<Product> productPage = productRepository.findByOrderByIdDesc(pageable);
        List<ProductResponse> productResponses = productPage.stream()
                .map(product -> {
                    UserResponse userResponse = UserResponse.builder()
                            .id(product.getUser().getId())
                            .firstName(product.getUser().getFirstname())
                            .lastName(product.getUser().getLastname())
                            .email(product.getUser().getEmail())
                            .role(product.getUser().getRole().name())
                            .phoneNumber(product.getUser().getPhoneNumber())
                            .profilePhoto(product.getUser().getProfilePhoto())
                            .status(product.getUser().getStatus())
                            .googleLink(product.getUser().getGoogleLink())
                            .mapLink(product.getUser().getMapLink())
                            .createdDate(product.getUser().getCreatedDate())
                            .build();

                    List<PhotoResponse> photoResponses = product.getPhotos().stream()
                            .map(photo -> PhotoResponse.builder()
                                    .id(photo.getId())
                                    .photo(photo.getPhoto())
                                    .build()).toList();

                    ProductResponse productResponse = ProductResponse.builder()
                            .id(product.getId())
                            .title(product.getTitle())
                            .description(product.getDescription())
                            .color(product.getColor())
                            .model(product.getModel())
                            .brand(product.getBrand())
                            .year(product.getYear())
                            .price(product.getPrice())
                            .discountPrice(product.getDiscountPrice())
                            .discountType(product.getDiscountType())
                            .size(product.getSize())
                            .status(product.getStatus())
                            .type(product.getType())
                            .isHidden(product.getIsHidden())
                            .user(userResponse)
                            .photo(photoResponses)
                            .createdDate(product.getCreatedDate())
                            .build();
                    return productResponse;
                }).toList();
        return ProductMainResponse.builder()
                .page(productPage)
                .products(productResponses)
                .build();
    }

    @Override
    public Object getAllProductByCurrentUser(Pageable pageable) {

        // get user id by login user
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = user.getId();
        Page<Product> productPage = productRepository.findByUser_Id(userId, pageable);
        List<ProductResponse> productResponses = productPage.stream()
                .map(product -> {
                    UserResponse userResponse = UserResponse.builder()
                            .id(product.getUser().getId())
                            .firstName(product.getUser().getFirstname())
                            .lastName(product.getUser().getLastname())
                            .email(product.getUser().getEmail())
                            .role(product.getUser().getRole().name())
                            .phoneNumber(product.getUser().getPhoneNumber())
                            .profilePhoto(product.getUser().getProfilePhoto())
                            .status(product.getUser().getStatus())
                            .googleLink(product.getUser().getGoogleLink())
                            .mapLink(product.getUser().getMapLink())
                            .createdDate(product.getUser().getCreatedDate())
                            .build();

                    List<PhotoResponse> photoResponses = product.getPhotos().stream()
                            .map(photo -> PhotoResponse.builder()
                                    .id(photo.getId())
                                    .photo(photo.getPhoto())
                                    .build()).toList();

                    ProductResponse productResponse = ProductResponse.builder()
                            .id(product.getId())
                            .title(product.getTitle())
                            .description(product.getDescription())
                            .color(product.getColor())
                            .model(product.getModel())
                            .brand(product.getBrand())
                            .year(product.getYear())
                            .price(product.getPrice())
                            .discountPrice(product.getDiscountPrice())
                            .discountType(product.getDiscountType())
                            .size(product.getSize())
                            .status(product.getStatus())
                            .type(product.getType())
                            .isHidden(product.getIsHidden())
                            .user(userResponse)
                            .photo(photoResponses)
                            .createdDate(product.getCreatedDate())
                            .build();
                    return productResponse;
                }).toList();
        return ProductMainResponse.builder()
                .page(productPage)
                .products(productResponses)
                .build();
    }

    @Override
    public ProductResponse getProductById(Long productId) {

        var product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException(Product.class, "id", productId.toString()));
        var user = UserResponse.builder()
                .id(product.getUser().getId())
                .firstName(product.getUser().getFirstname())
                .lastName(product.getUser().getLastname())
                .email(product.getUser().getEmail())
                .role(product.getUser().getRole().name())
                .phoneNumber(product.getUser().getPhoneNumber())
                .profilePhoto(product.getUser().getProfilePhoto())
                .status(product.getUser().getStatus())
                .googleLink(product.getUser().getGoogleLink())
                .mapLink(product.getUser().getMapLink())
                .createdDate(product.getUser().getCreatedDate())
                .build();
        var allPhoto = product.getPhotos();
        var photoResponse = allPhoto.stream()
                .map(photo -> PhotoResponse.builder()
                        .id(photo.getId())
                        .photo(photo.getPhoto())
                        .build()
                ).toList();

        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .color(product.getColor())
                .model(product.getModel())
                .brand(product.getBrand())
                .year(product.getYear())
                .price(product.getPrice())
                .discountPrice(product.getDiscountPrice())
                .discountType(product.getDiscountType())
                .size(product.getSize())
                .status(product.getStatus())
                .type(product.getType())
                .user(user)
                .createdDate((product.getCreatedDate()))
                .photo(photoResponse)
                .build();
    }

    @Override
    public void hiddenProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException(Product.class, "id", productId.toString()));
        product.setIsHidden(true);
        productRepository.save(product);
    }

}
