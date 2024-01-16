package com.sakshath.core.serviceImpl;

import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakshath.core.Exception.CustomerInfoException;
import com.sakshath.core.constant.HttpCode;
import com.sakshath.core.constant.ResponseMessage;
import com.sakshath.core.entities.CustomerInfo;
import com.sakshath.core.repository.CustomerInfoRepository;
import com.sakshath.core.response.Response;
import com.sakshath.core.service.CustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
	
	Logger logger = LoggerFactory.getLogger(CustomerInfoServiceImpl.class);
	
	@Autowired
	CustomerInfoRepository customerInfoRepository;
	
	
	@Override
	public CustomerInfo fetchCustomerInfoByCusotmerId(long customerId) throws CustomerInfoException {
		final String method = "CustomerInfoServiceImpl : fetchCustomerInfoByCusotmerId(long customerId)";

		logger.info(method);

		final Optional<CustomerInfo> customerInfoOptional = customerInfoRepository.findById(customerId);

		final Response<CustomerInfo> response = new Response<>();
		
		
		if (Objects.isNull(customerInfoOptional) || !customerInfoOptional.isPresent()) {
			logger.error("customerInfoRepository.fetchCustomerInfoByCusotmerId is returning Null when fetchCustomerInfoByCusotmerId call");
			response.setCode(HttpCode.NULL_OBJECT);
			response.setMessage(ResponseMessage.CUSTOMER_INFO_RECORD_FETCH_BY_ID_FAILED_MESSAGE);
			throw new CustomerInfoException(response);
		} else {
			CustomerInfo customerInfo = customerInfoOptional.get();
						return customerInfo;
		}
	}

	@Override
	public CustomerInfo fetchCustomerInfoByMobileNo(String mobileNo) throws CustomerInfoException {
		final String method = "CustomerInfoServiceImpl : fetchCustomerInfoByCusotmerId(long customerId)";

		logger.info(method);

		final Optional<CustomerInfo> customerInfoOptional = customerInfoRepository.findByMobileNumber(mobileNo);

		final Response<CustomerInfo> response = new Response<>();
		
		
		if (Objects.isNull(customerInfoOptional) || !customerInfoOptional.isPresent()) {
			logger.error("customerInfoRepository.findByMobileNumber is returning Null when fetchCustomerInfoByMobileNo call");
			response.setCode(HttpCode.NULL_OBJECT);
			response.setMessage(ResponseMessage.CUSTOMER_INFO_RECORD_FETCH_BY_MOBILE_FAILED_MESSAGE);
			throw new CustomerInfoException(response);
		} else {
			CustomerInfo customerInfo = customerInfoOptional.get();
						return customerInfo;
		}
	}

	


}
