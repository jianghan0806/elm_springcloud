package edu.ynu.ls.businessservice.impl;


import edu.ynu.ls.businessservice.dao.IBusinessDao;
import edu.ynu.ls.businessservice.service.IBusinessService;
import edu.ynu.ls.common.pojo.Business;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class BusinessServiceImpl implements IBusinessService {
    @Resource
    IBusinessDao iBusinessDao;
    @Override
    public Business getByBusinessId(int businessId){
        return iBusinessDao.findBusinessByBusinessId(businessId);
    }
    @Override
    public List<Business> getByBusinessNameContaining(String businessName){
        return  iBusinessDao.findBusinessesByBusinessNameContaining(businessName);
    }
    @Override
    public List<Business> getAll(){
        return iBusinessDao.findAll();
    }
    @Override
    public List<Business> getByOrderTypeId(int orderTypeId){
        return iBusinessDao.findBusinessesByOrderTypeId(orderTypeId);
    }
}
