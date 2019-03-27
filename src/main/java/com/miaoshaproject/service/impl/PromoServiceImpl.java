package com.miaoshaproject.service.impl;


import com.miaoshaproject.dao.PromoDOMapper;
import com.miaoshaproject.dataobject.PromoDO;
import com.miaoshaproject.service.PromoService;
import com.miaoshaproject.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDOMapper promoDOMapper;


    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        PromoDO promoDo = promoDOMapper.selectByItemId(itemId);

        //dataobject->model
        PromoModel promoModel = convertFromDataObject(promoDo);

        if(promoModel == null) {
            return null;
        }
        //判断
        if(promoModel.getStartDate().isAfterNow()) {
            promoModel.setStatus(1);
        }else if(promoModel.getEndDate().isBeforeNow()) {
            promoModel.setStatus(3);
        }else{
            promoModel.setStatus(2);
        }


        return promoModel;
    }


    private PromoModel convertFromDataObject(PromoDO promoDO) {
        if(promoDO==null) {
            return null;
        }
        PromoModel promoModel = new PromoModel();
        DateTime dateTime = new DateTime();
        BeanUtils.copyProperties(promoDO,promoModel);
        promoModel.setPromoItemPrice(new BigDecimal(promoDO.getPromoItemPrice()));
        promoModel.setStartDate(new DateTime(promoDO.getStartDate()));
        promoModel.setEndDate(new DateTime(promoDO.getEndDate()));
        DateTime off = promoModel.getEndDate().plusMinutes(30);
        if(off.isBeforeNow())
        {
            return null;
        }
        return promoModel;
    }
}
