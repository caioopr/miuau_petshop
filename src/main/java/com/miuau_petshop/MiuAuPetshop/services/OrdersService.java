package com.miuau_petshop.MiuAuPetshop.services;

import com.miuau_petshop.MiuAuPetshop.dtos.OrderDTO;
import com.miuau_petshop.MiuAuPetshop.dtos.OrderItemsDTO;
import com.miuau_petshop.MiuAuPetshop.entities.*;
import com.miuau_petshop.MiuAuPetshop.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    // repositories dependency injection
    @Autowired
    final private OrdersRepository ordersRepository;
    @Autowired
    final private UsersRepository usersRepository;
    @Autowired
    final private EmployeesRepository employeesRepository;
    @Autowired
    final private OrderItemsRepository orderItemsRepository;
    @Autowired
    final private ProductsRepository productsRepository;

    OrdersService(
            OrdersRepository ordersRepository,
            UsersRepository usersRepository,
            EmployeesRepository employeesRepository,
            OrderItemsRepository orderItemsRepository,
            ProductsRepository productsRepository
    ){
        this.ordersRepository = ordersRepository;
        this.usersRepository = usersRepository;
        this.employeesRepository = employeesRepository;
        this.orderItemsRepository = orderItemsRepository;
        this.productsRepository = productsRepository;
    }

    @Transactional
    public OrderEntity save(OrderDTO orderDTO){
        // verifica se o cliente e o vendedor existe e o vendedor existem
        Integer clientID = orderDTO.userId();
        Integer sellerID = orderDTO.sellerId();

        UserEntity client = usersRepository
                .findById(clientID)
                .orElseThrow(() -> new Error());
        EmployeeEntity seller = employeesRepository
                .findById(sellerID)
                .orElseThrow(() -> new Error());

        OrderEntity order = new OrderEntity();
        order.setUser(client);
        order.setSeller(seller);
        order.setCommission(orderDTO.commission());


        List<OrderItemsEntity> orderItems = orderProductsDTOListToOrderItemsEntityList(order, orderDTO.orderProducts());


        //salvar pedido
        ordersRepository.save(order);

        //salvar itens do pedidos
        orderItemsRepository.saveAll(orderItems);

        return order;
    }

    public List<OrderEntity> getOrders(){
        return ordersRepository.findAll();
    }



    // Converte a lista de itens do DTO do pedido em uma lista de OrderItemsEntity
    private List<OrderItemsEntity> orderProductsDTOListToOrderItemsEntityList(OrderEntity order, List<OrderItemsDTO> dtoProductsList){
        if(dtoProductsList.isEmpty()){
            return List.of();
        }

        return dtoProductsList.stream()
                .map( orderItemDTO -> {
                    ProductEntity product = productsRepository
                            .findById(orderItemDTO.productID())
                            .orElseThrow(
                                    () -> new RuntimeException("Product not found!"));

                    OrderItemsEntity orderItem = new OrderItemsEntity(null ,order, product, orderItemDTO.quantity());
                    return orderItem;
                }).collect(Collectors.toList());
    }
}


