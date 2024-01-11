package com.sakshath.core.service;

import com.sakshath.core.Exception.CustomerInfoException;
import com.sakshath.core.entities.CustomerInfo;

public interface CustomerInfoService {

	CustomerInfo fetchCustomerInfoByCusotmerId(long customerId) throws CustomerInfoException;

	CustomerInfo fetchCustomerInfoByMobileNo(String mobileNo) throws CustomerInfoException;

}
