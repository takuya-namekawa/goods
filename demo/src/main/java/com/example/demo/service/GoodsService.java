package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Goods;
import com.example.demo.repository.GoodsRepository;

@Service
public class GoodsService {
	private final GoodsRepository goodsRepository;
	
	public GoodsService(GoodsRepository goodsRepository) {
		this.goodsRepository = goodsRepository;
	}
	
	
	public void saveGoods(Goods goods) {
		goodsRepository.save(goods);
	}
	
	public List<Goods> findByGoodsId(Integer goodsId) {
		return goodsRepository.findByGoodsId(goodsId);
	}
}
