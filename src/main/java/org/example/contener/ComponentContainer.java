package org.example.contener;

import org.example.controller.*;
import org.example.repository.*;
import org.example.service.*;

import java.util.Scanner;

public class ComponentContainer {

    //======================scanner=================
    public static Scanner scannerInt = new Scanner(System.in);
    public static Scanner scannerStr = new Scanner(System.in);
    //===================== controller================

    public static MainController mainController = new MainController();
    public static UserController userController = new UserController();
    public static AdminController adminController = new AdminController();
    public static CategoryController categoryController = new CategoryController();
    public static ProductController productController = new ProductController();
    public static CustomerController customerController = new CustomerController();
    public static BasketController basketController = new BasketController();

//============================== service ========================

    public static UserService userService = new UserService();
    public static AdminService adminService = new AdminService();
    public static CategoryService categoryService = new CategoryService();
    public static ProductService productService = new ProductService();
    public static CustomerService customerService = new CustomerService();
    public static BasketService basketService = new BasketService();


    //=========================== repository=============================

    public static UserRepository userRepository = new UserRepository();
    public static AdminRepository adminRepository = new AdminRepository();
    public static CategoryRepository categoryRepository = new CategoryRepository();
    public static ProductRepository productRepository = new ProductRepository();
    public static CustomerRepository customerRepository = new CustomerRepository();
    public static BasketRepository basketRepository = new BasketRepository();

}
