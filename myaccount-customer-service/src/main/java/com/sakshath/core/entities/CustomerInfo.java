package com.sakshath.core.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "company_code")
	private String companyCode;

	@Column(name = "source_system_name")
	private String sourceSystemName;

	@Column(name = "preferred_contact_address_type")
	private String prefContactAddType;

	@Column(name = "customer_id")
	private String customerId;

	@Column(name = "preferred_mailing_address_type")
	private String prefMailAddType;

	@Column(name = "group_id")
	private String groupId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "customer_type")
	private String customerType;

	@Column(name = "customer_category")
	private String customerCategory;

	@Column(name = "title")
	private String title;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth")
	private Date dob;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "pan_number")
	private String panNumber;

	@Column(name = "aadhaar_number")
	private String aadhaarNumber;

	@Column(name = "passport_number	")
	private String passportNumber;

	@Column(name = "driving_license_number")
	private String drivingLicenseNumber;

	@Column(name = "other_identity_card_number")
	private String otherIdentityCardNumber;

	@Column(name = "occupation_type")
	private String occupationType;

	@Column(name = "employer_name")
	private String employerName;

	@Column(name = "designation")
	private String designation;

	@Column(name = "years_of_employment")
	private BigDecimal yearsOfEmployment;

	@Column(name = "industry_name")
	private String industryName;

	@Column(name = "annual_income")
	private BigDecimal annualIncome;

	@Column(name = "family_income")
	private BigDecimal familyIncome;

	@Column(name = "bank_account_number")
	private String bankAccountNumber;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "bank_ifsc")
	private String bankIFSC;

	@Column(name = "bank_miscr")
	private String bankMICR;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "contact_person")
	private String contactPerson;

	@Column(name = "customer_risk_category")
	private String customerRiskCategory;

	@Column(name = "customer_segment")
	private String customerSegment;

	@Column(name = "cin")
	private String cin;

	@Column(name = "gstin")
	private String gstin;

	@Column(name = "tan")
	private String tan;

	// auditable

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@JsonIgnore
	@CreatedDate
	@Column(name = "created")
	private Date created;

	@JsonIgnore
	@Column(name = "updated_by")
	private String updatedBy;

	@JsonIgnore
	@Column(name = "updated")
	private Date updated;
	
//	@JsonIgnore
//	@Column(name = "is_active")
//	private Boolean active;
//
//	@JsonIgnore
//	@Column(name = "is_deleted")
//	private boolean isDeleted;

	

}
