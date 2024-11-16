package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        if (goods.getCOUNTER_HANDOVER_FRAG() == null) {
        	goodsForm.setCounterHandoverFrag('0');
        } else {
        	goodsForm.setCounterHandoverFrag(goods.getCOUNTER_HANDOVER_FRAG());
        }
      
        goodsForm.setCounterHandoverDate(goods.getCOUNTER_HANDOVER_DATE());

        // モデルにGoodsFormを追加してビューに渡す
        model.addAttribute("goodsForm", goodsForm);
		
		
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
