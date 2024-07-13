package edu.ynu.ls.businessservice.service;


import edu.ynu.ls.common.pojo.Business;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBusinessService {
    List<Business> getByBusinessNameContaining(String businessName);
    List<Business> getAll();
    Business getByBusinessId(int businessId);
    List<Business> getByOrderTypeId(int orderTypeId);
}
