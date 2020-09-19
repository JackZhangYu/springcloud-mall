package com.mall.userservice.dao;

import com.mall.userservice.model.StockModel;
import com.mall.userservice.model.StockModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IStockDao {
    long countByExample(StockModelExample example);

    int deleteByExample(StockModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StockModel record);

    int insertSelective(StockModel record);

    List<StockModel> selectByExample(StockModelExample example);

    StockModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StockModel record, @Param("example") StockModelExample example);

    int updateByExample(@Param("record") StockModel record, @Param("example") StockModelExample example);

    int updateByPrimaryKeySelective(StockModel record);

    int updateByPrimaryKey(StockModel record);
}