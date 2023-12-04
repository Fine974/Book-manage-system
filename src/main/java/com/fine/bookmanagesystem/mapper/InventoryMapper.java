package com.fine.bookmanagesystem.mapper;

import com.fine.bookmanagesystem.model.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InventoryMapper {

    // 查询所有库存
    List<Inventory> getAllInventory();

    // 根据图书ID查询库存
    Inventory getInventoryByProductId(@Param("productId") int productId);

    // 更新库存信息
    void updateInventory(Inventory inventory);

    // 手动调整库存
    void adjustInventory(@Param("productId") int productId, @Param("quantity") int quantity);
}
