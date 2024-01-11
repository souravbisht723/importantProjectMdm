package com.sakshath.core.constant;

public interface RestApiUrl {
	
	public static final String USER_BASE_URL = "/api/user";

	/*
	 * Customer Base URL for REST API's If Customer Logged..
	 */
	public static final String CUSTOMER_BASE_URL = "/api/customer";

	/*
	 * URL to add new record.
	 */
	public static final String ADD_URL = "/add";

	/*
	 * URL to delete new record.
	 */
	public static final String DELETE_URL = "/delete/{id}";

	/*
	 * URL to update existing record.
	 */
	public static final String UPDATE_URL = "/update/{id}";

	/*
	 * URL to retrieve specific record.
	 */
	public static final String GET_URL = "/get/{id}";

	/*
	 * URL to Retrieve all record's.
	 */
	public static final String GET_ALL_URL = "/getAll";


	/*
	 * API for Controllers
	 */

	/*
	 * CustomersInfo Controller.
	 */
	public static final String CUSTOMER_TYPE_TAGS = "customer-info";
	public static final String CUSTOMER_TYPE_API = CUSTOMER_BASE_URL + "/" + CUSTOMER_TYPE_TAGS;
	
	public static final String GET_CUSTOMER_INFO_BY_MOBILENO_URL = "/getCustomerInfoByMobile/{mobileNo}";




}
