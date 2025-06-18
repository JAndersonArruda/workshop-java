package com.compassoul.workshop.config;

import com.compassoul.workshop.entities.Category;
import com.compassoul.workshop.entities.Order;
import com.compassoul.workshop.entities.Product;
import com.compassoul.workshop.entities.User;
import com.compassoul.workshop.entities.enums.OrderStatus;
import com.compassoul.workshop.repositories.CategoryRepository;
import com.compassoul.workshop.repositories.OrderRepository;
import com.compassoul.workshop.repositories.ProductRepository;
import com.compassoul.workshop.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired  // Optional declaration
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(
                category1,
                category2,
                category3
        ));

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(
                product1,
                product2,
                product3,
                product4,
                product5
        ));

        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User user3 = new User(null, "José White", "jose@gmail.com", "966666666", "123456");

        userRepository.saveAll(Arrays.asList(
                user1,
                user2,
                user3
        ));

        orderRepository.saveAll(Arrays.asList(
                new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1),
                new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2),
                new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1)
        ));
    }
}
