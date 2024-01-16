package com.sakshath.core.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakshath.core.Exception.CustomerInfoException;
import com.sakshath.core.Exception.FormValidationException;
import com.sakshath.core.Exception.InvalidAuthenticationException;
import com.sakshath.core.constant.HttpCode;
import com.sakshath.core.constant.ResponseMessage;
import com.sakshath.core.constant.RestApiUrl;
import com.sakshath.core.entities.CustomerInfo;
import com.sakshath.core.response.Response;
import com.sakshath.core.service.CustomerInfoService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(value = "CustomerInfoController", description = "Rest api for CustomerInfoController.")
@RestController
@RequestMapping(RestApiUrl.CUSTOMER_TYPE_API)
public class CustomerInfoController {
	

	Logger LOG = LoggerFactory.getLogger(CustomerInfoController.class);

	@Autowired
	private CustomerInfoService customerInfoService;
	
	
	@GetMapping(RestApiUrl.GET_URL)
	public ResponseEntity<Response<?>> retrieveCustomerInfoByCusomerId(@PathVariable long id,
			HttpServletResponse httpServletResponse) throws FormValidationException, InvalidAuthenticationException,CustomerInfoException{

		
		final String method = RestApiUrl.CUSTOMER_BASE_URL + RestApiUrl.GET_URL + " : retrieveCustomerInfoByCusomerId()";

		LOG.info(method);
		Response<CustomerInfo> response = new Response();

		 CustomerInfo customerInfoResponse = customerInfoService.fetchCustomerInfoByCusotmerId(id);

		response.setList(Arrays.asList(customerInfoResponse));
		response.setCode(HttpCode.OK);
		response.setMessage("Records retrieved Successfully !");
		System.out.println(response);
		return ResponseEntity.ok().header(ResponseMessage.APPLICATION_TYPE_JSON).body(response);

	}
	
	@GetMapping(RestApiUrl.GET_CUSTOMER_INFO_BY_MOBILENO_URL)
	public ResponseEntity<Response<?>> retrieveCustomerInfoByMobileNo(@PathVariable String mobileNo,
			HttpServletResponse httpServletResponse) throws FormValidationException, InvalidAuthenticationException,CustomerInfoException{

		
		final String method = RestApiUrl.CUSTOMER_BASE_URL + RestApiUrl.GET_CUSTOMER_INFO_BY_MOBILENO_URL + " : retrieveCustomerInfoByMobileNo()";

		LOG.info(method);
		Response<CustomerInfo> response = new Response();

		 CustomerInfo customerInfoResponse = customerInfoService.fetchCustomerInfoByMobileNo(mobileNo);

		response.setList(Arrays.asList(customerInfoResponse));
		response.setCode(HttpCode.OK);
		response.setMessage("Records retrieved Successfully !");
		System.out.println(response);
		return ResponseEntity.ok().header(ResponseMessage.APPLICATION_TYPE_JSON).body(response);

	}
	
	

}
