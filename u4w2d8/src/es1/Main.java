package es1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Book1", "Books", 120.0));
        productList.add(new Product(2L, "Book2", "Books", 90.0));
        productList.add(new Product(3L, "Book3", "Books", 800.0));

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1L, "Shipped", LocalDate.now(), LocalDate.now().plusDays(3), productList.subList(0, 2), new Customer(1L, "John Doe", 2)));

        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1L, "Mario Rossi", 2));


        List<Product> expensiveBooks = productList.stream()
                .filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100)
                .collect(Collectors.toList());


        System.out.println("Lista di prodotti costosi della categoria 'Books':");
        expensiveBooks.forEach(product -> System.out.println(product.getName()));
    }
}
