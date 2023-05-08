package shop.mtcoding.productapp_v4.model.orders;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.productapp_v4.dto.orders.OrdersDto;

@Mapper
public interface OrdersRepository {


    public void insert(@Param("ordersDto") OrdersDto ordersDto, @Param("userId") Integer userId);

    public Orders findById(Integer ordersId);

    public List<Orders> findAll(Integer userId);

    public void orderUpdatebyProductQty(Orders orders);

    public void delete(Integer ordersId);
}