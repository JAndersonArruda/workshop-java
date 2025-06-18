package com.compassoul.workshop.config;

import com.compassoul.workshop.entities.Category;
import com.compassoul.workshop.entities.Order;
import com.compassoul.workshop.entities.User;
import com.compassoul.workshop.entities.enums.OrderStatus;
import com.compassoul.workshop.repositories.CategoryRepository;
import com.compassoul.workshop.repositories.OrderRepository;
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

    @Autowired  // Optional declaration
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
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
