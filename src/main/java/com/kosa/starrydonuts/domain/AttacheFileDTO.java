package com.kosa.starrydonuts.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor // κΈ??°κΈ?
public class AttacheFileDTO {

	// ??
	private int fileNo; 			// μ²¨λ???Ό ??΄?
	private int boardid; 			// κ²μκΈ?λ²νΈ
	private String fileNameOrg;		// ?¬?©?κ°? ?¬λ¦? ?λ³? ??Όλͺ? 
	private String fileNameReal;	// ?λ²μ ???₯? ??Όλͺ? 
	private int    length;			// ??Ό? κΈΈμ΄
	private String contentType;		// μ»¨νμΈ? ???
	private Date   reg_date;		// ?±λ‘μΌ?
	
} // AttacheFileDTO

