package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.Request.CreateReviewRequestDto;
import com.example.EcommerceSpring.Dtos.Response.GetReviewResponseDto;
import com.example.EcommerceSpring.Repository.OrderRepository;
import com.example.EcommerceSpring.Repository.ProductRepository;
import com.example.EcommerceSpring.Repository.ReviewRepository;
import com.example.EcommerceSpring.Schema.Order;
import com.example.EcommerceSpring.Schema.Product;
import com.example.EcommerceSpring.Schema.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public List<GetReviewResponseDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();

        Set<Long> orderIds = reviews.stream()
            .map(review -> review.getOrder()
                .getId())
            .collect(Collectors.toSet());

        Set<Long> productIds = reviews.stream()
            .map(review -> review.getProduct()
                .getId())
            .collect(Collectors.toSet());

        Map<Long, Order> ordersById = orderRepository.findAllById(orderIds)
            .stream()
            .collect(Collectors.toMap(Order::getId,
                order -> order));

        Map<Long, Product> productsById = productRepository.findAllById(productIds)
            .stream()
            .collect(Collectors.toMap(Product::getId,
                product -> product));

        return reviews.stream()
            .map(review -> {
                Long orderKey = review.getOrder()
                    .getId();
                Long productKey = review.getProduct()
                    .getId();

                Order order = ordersById.get(orderKey);
                Product product = productsById.get(productKey);

                return GetReviewResponseDto.builder()
                    .id(review.getId())
                    .comment(review.getComment())
                    .rating(review.getRating())
                    .orderId(order != null ? order.getId() : orderKey)
                    .productId(product != null ? product.getId() : productKey)
                    .createdAt(review.getCreatedAt())
                    .updatedAt(review.getUpdatedAt())
                    .build();
            })
            .toList();
    }

    @Override
    public List<GetReviewResponseDto> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId); // FIX: product endpoint must filter by product_id
        return reviews.stream()
            .map(r -> GetReviewResponseDto.builder()
                .id(r.getId())
                .comment(r.getComment())
                .rating(r.getRating())
                .orderId(r.getOrder()
                    .getId())
                .productId(r.getProduct()
                    .getId())
                .createdAt(r.getCreatedAt())
                .updatedAt(r.getUpdatedAt())
                .build())
            .toList();
    }

    @Override
    public List<GetReviewResponseDto> getReviewsByOrderId(Long id) {
        List<Review> reviews = reviewRepository.findByOrderId(id); // FIX: order endpoint must filter by order_id
        return reviews.stream()
            .map(x -> GetReviewResponseDto.builder()
                .id(x.getId())
                .comment(x.getComment())
                .rating(x.getRating())
                .orderId(x.getOrder()
                    .getId())
                .productId(x.getProduct()
                    .getId())
                .createdAt(x.getCreatedAt())
                .updatedAt(x.getUpdatedAt())
                .build())
            .toList();
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public GetReviewResponseDto createReview(CreateReviewRequestDto createReviewRequestDto) {
        Order order = Order.builder()
            .build();
        order.setId(createReviewRequestDto.getOrderId());

        Product product = Product.builder()
            .build();
        product.setId(createReviewRequestDto.getProductId());

        Review review = Review.builder()
            .comment(createReviewRequestDto.getComment())
            .order(order)
            .product(product)
            .rating(createReviewRequestDto.getRating())
            .build();

        Review savedReview = reviewRepository.save(review);

        return GetReviewResponseDto.builder()
            .id(savedReview.getId())
            .comment(savedReview.getComment())
            .rating(savedReview.getRating())
            .orderId(savedReview.getOrder()
                .getId())
            .productId(savedReview.getProduct()
                .getId())
            .createdAt(savedReview.getCreatedAt())
            .updatedAt(savedReview.getUpdatedAt())
            .build();
    }

    @Override
    public GetReviewResponseDto getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Review not found"));

        return GetReviewResponseDto.builder()
            .id(review.getId())
            .comment(review.getComment())
            .rating(review.getRating())
            .orderId(review.getOrder()
                .getId())
            .productId(review.getProduct()
                .getId())
            .createdAt(review.getCreatedAt())
            .updatedAt(review.getUpdatedAt())
            .build();
    }
}
