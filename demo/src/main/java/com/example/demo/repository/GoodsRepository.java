package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Integer>{
	List<Goods> findByGoodsId(Integer goodsId);
}
