package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Goods;
import com.example.demo.form.GoodsForm;
import com.example.demo.service.GoodsService;

@Controller
public class SampleContoroller {
	
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping("goods/{goodsId}")
	public ModelAndView getGoods(@PathVariable Integer goodsId, Model model) {
		List<Goods> goodsList = goodsService.findByGoodsId(goodsId);
		
		Goods goods = goodsList.get(0);
		
		GoodsForm goodsForm = new GoodsForm();
        goodsForm.setGoodsId(goods.getGoodsId());
        goodsForm.setFanType(goods.getFAN_TYPE());
        
        if (goods.getCOUNTER_HANDOVER_FRAG() == null || goods.getCOUNTER_HANDOVER_FRAG().equals('0')) {
        	goodsForm.setCounterHandoverFrag('0');
        	goodsForm.setCounterHandoverDate(null);
        } else {
        	goodsForm.setCounterHandoverFrag(goods.getCOUNTER_HANDOVER_FRAG());
        	goodsForm.setCounterHandoverDate(LocalDate.now());
        }

        // モデルにGoodsFormを追加してビューに渡す
        model.addAttribute("goodsForm", goodsForm);
			
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@PostMapping("goods/{goodsId}")
	public ModelAndView updateGoods(@PathVariable Integer goodsId, GoodsForm goodsForm, Model model) {
		List<Goods> goodsList = goodsService.findByGoodsId(goodsId);
		
		Goods goods = goodsList.get(0);
		
		if (goodsForm.getCounterHandoverFrag() == null || goodsForm.getCounterHandoverFrag().equals('0')) {
			goodsForm.setCounterHandoverFrag('0');
			goods.setCOUNTER_HANDOVER_FRAG(goodsForm.getCounterHandoverFrag());
			
			goodsForm.setCounterHandoverDate(null);
			goods.setCOUNTER_HANDOVER_DATE(null);		
		} else {
			goodsForm.setCounterHandoverFrag('1');
			goods.setCOUNTER_HANDOVER_FRAG(goodsForm.getCounterHandoverFrag());
			
			goodsForm.setCounterHandoverDate(LocalDate.now());
		}
		
		goodsService.saveGoods(goods);
		
		model.addAttribute("goodsForm", goodsForm);
		
		ModelAndView mv = new ModelAndView("index");
		return mv;
		
	}
}
