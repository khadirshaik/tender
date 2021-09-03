create table PRT_GDFTender_SubFPPMat_Det (
	GDF_Tender_Item_Mat_Ref_Id LONG not null primary key IDENTITY,
	GDF_Tender_Schedule_Number LONG,
	GDF_Generic_Code VARCHAR(100) null,
	GDF_Tender_Reference_Number VARCHAR(100) null,
	Dosage_Form VARCHAR(100) null,
	No_Prim_Package_Units LONG,
	No_Sec_Package_Units LONG,
	Gdf_Fpp_Mart_Appr_Status VARCHAR(100) null,
	FPP_Selected_Status BOOLEAN,
	FPP_Market_Id LONG,
	GDF_Tender_Item_Ref_Id LONG,
	userId LONG,
	userName VARCHAR(100) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PRT_GDFTender_SubFppReg_Det (
	GDF_Tender_Reg_Ref_Id LONG not null primary key IDENTITY,
	GDF_Tender_Schedule_Number LONG,
	GDF_Generic_Code VARCHAR(100) null,
	GDF_Tender_Reference_Number VARCHAR(100) null,
	listOf_Registration_Countries VARCHAR(100) null,
	FPP_Reg_Appr_Status VARCHAR(100) null,
	FPP_Reg_Accepted BOOLEAN,
	FPP_Registration_ID LONG,
	GDF_Tender_Item_Mat_Ref_Id LONG,
	GDF_Tender_Item_Ref_Id LONG,
	userId LONG,
	userName VARCHAR(100) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PRT_GDFTender_SubSched_Det (
	GDF_Tender_Sub_Sched_Ref_Id LONG not null primary key IDENTITY,
	GDF_Tender_Item_Num LONG,
	GDF_Tender_Schedule_Number LONG,
	GDF_Generic_Code VARCHAR(75) null,
	GDF_Tender_Reference_Number VARCHAR(75) null,
	GDF_Tender_Schedule_Name VARCHAR(75) null,
	GDF_PatientTarget VARCHAR(75) null,
	GDF_Tender_Item_Ref_Id LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PRT_GDFTender_Subm_Details (
	GDF_Tender_Sub_Ref_Id LONG not null primary key IDENTITY,
	GDF_Tender_Reference_Number VARCHAR(100) null,
	Copy_Of_Reg_Cert VARCHAR(1000) null,
	Supplier_Name VARCHAR(100) null,
	Name_Of_Auth_Repr VARCHAR(100) null,
	Supplier_Title VARCHAR(100) null,
	Supplier_Email_Address VARCHAR(100) null,
	Supplier_Telephone_Number VARCHAR(100) null,
	Submission_Status VARCHAR(100) null,
	supplierId LONG,
	userName VARCHAR(100) null,
	createDate DATE null,
	modifiedDate DATE null,
	submittedDate DATE null
);

create table PRT_GDF_Tender_Details (
	GDF_Tender_Ref_Id LONG not null primary key IDENTITY,
	Product_Category VARCHAR(100) null,
	GDF_Tender_Reference_Number VARCHAR(100) null,
	title VARCHAR(100) null,
	Date_Of_Publication DATE null,
	Deadline_For_Tech_Bids_Sub DATE null,
	Method VARCHAR(100) null,
	Status VARCHAR(100) null,
	deadlineTimeForTechBidsSub DATE null,
	userId LONG,
	userName VARCHAR(100) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PRT_GDF_Tender_Item_Details (
	GDF_Tender_Item_Ref_Id LONG not null primary key IDENTITY,
	GDF_Tender_Item_Num LONG,
	GDF_Tender_Schedule_Number LONG,
	GDF_Generic_Desc VARCHAR(500) null,
	Prim_Packaging VARCHAR(500) null,
	Sec_Packaging VARCHAR(500) null,
	GDF_Generic_Code VARCHAR(100) null,
	GDF_Tender_Reference_Number VARCHAR(100) null,
	GDF_Tender_Schedule_Name VARCHAR(100) null,
	GDF_PatientTarget VARCHAR(100) null,
	userId LONG,
	userName VARCHAR(100) null,
	createDate DATE null,
	modifiedDate DATE null
);