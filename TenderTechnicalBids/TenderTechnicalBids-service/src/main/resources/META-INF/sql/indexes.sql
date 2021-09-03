create index IX_29BF88C9 on PRT_GDFTender_SubFPPMat_Det (FPP_Market_Id, userId, GDF_Generic_Code[$COLUMN_LENGTH:100$], GDF_Tender_Schedule_Number, GDF_Tender_Reference_Number[$COLUMN_LENGTH:100$]);
create index IX_B04D01C8 on PRT_GDFTender_SubFPPMat_Det (FPP_Selected_Status);
create index IX_E1C136E4 on PRT_GDFTender_SubFPPMat_Det (GDF_Generic_Code[$COLUMN_LENGTH:100$]);
create index IX_3FDF1C3F on PRT_GDFTender_SubFPPMat_Det (GDF_Tender_Item_Mat_Ref_Id, FPP_Market_Id);
create index IX_51AE53D7 on PRT_GDFTender_SubFPPMat_Det (GDF_Tender_Reference_Number[$COLUMN_LENGTH:100$], userId);
create index IX_8C41B174 on PRT_GDFTender_SubFPPMat_Det (GDF_Tender_Schedule_Number, GDF_Generic_Code[$COLUMN_LENGTH:100$]);

create index IX_F54F1F7F on PRT_GDFTender_SubFppReg_Det (FPP_Registration_ID);
create index IX_95656A18 on PRT_GDFTender_SubFppReg_Det (GDF_Generic_Code[$COLUMN_LENGTH:100$]);
create index IX_5E1ECC23 on PRT_GDFTender_SubFppReg_Det (GDF_Tender_Reference_Number[$COLUMN_LENGTH:100$], userId);
create index IX_E7D48DA on PRT_GDFTender_SubFppReg_Det (GDF_Tender_Reg_Ref_Id, FPP_Registration_ID);
create index IX_97FE2D58 on PRT_GDFTender_SubFppReg_Det (GDF_Tender_Schedule_Number, GDF_Tender_Reference_Number[$COLUMN_LENGTH:100$], GDF_Generic_Code[$COLUMN_LENGTH:100$]);
create index IX_FBBB3CDA on PRT_GDFTender_SubFppReg_Det (GDF_Tender_Schedule_Number, userId, GDF_Tender_Reference_Number[$COLUMN_LENGTH:100$], GDF_Generic_Code[$COLUMN_LENGTH:100$], FPP_Registration_ID);

create index IX_5199FABF on PRT_GDFTender_SubSched_Det (GDF_Generic_Code[$COLUMN_LENGTH:75$]);
create index IX_31ED1EB2 on PRT_GDFTender_SubSched_Det (GDF_Tender_Item_Ref_Id);
create index IX_3478BDE2 on PRT_GDFTender_SubSched_Det (GDF_Tender_Reference_Number[$COLUMN_LENGTH:75$]);
create index IX_EADC4DED on PRT_GDFTender_SubSched_Det (GDF_Tender_Schedule_Number, GDF_Tender_Reference_Number[$COLUMN_LENGTH:75$], GDF_Tender_Item_Num);

create unique index IX_ECA42C78 on PRT_GDFTender_Subm_Details (GDF_Tender_Reference_Number[$COLUMN_LENGTH:100$], supplierId);
create index IX_2B37C180 on PRT_GDFTender_Subm_Details (supplierId);

create unique index IX_26F45582 on PRT_GDF_Tender_Details (GDF_Tender_Reference_Number[$COLUMN_LENGTH:100$]);
create index IX_4D78741A on PRT_GDF_Tender_Details (userId);

create unique index IX_A3EA8F9A on PRT_GDF_Tender_Item_Details (GDF_Tender_Item_Num, GDF_Generic_Code[$COLUMN_LENGTH:100$]);
create unique index IX_68BC8EAB on PRT_GDF_Tender_Item_Details (GDF_Tender_Item_Num, GDF_Tender_Schedule_Number);
create index IX_BB386A55 on PRT_GDF_Tender_Item_Details (GDF_Tender_Item_Num, userId);
create unique index IX_1B24FED0 on PRT_GDF_Tender_Item_Details (GDF_Tender_Reference_Number[$COLUMN_LENGTH:100$], GDF_Tender_Item_Num, GDF_Tender_Schedule_Number, GDF_Generic_Code[$COLUMN_LENGTH:100$]);
create index IX_90F3CA38 on PRT_GDF_Tender_Item_Details (GDF_Tender_Reference_Number[$COLUMN_LENGTH:100$], userId);
create index IX_BBF0C9F4 on PRT_GDF_Tender_Item_Details (GDF_Tender_Schedule_Number);