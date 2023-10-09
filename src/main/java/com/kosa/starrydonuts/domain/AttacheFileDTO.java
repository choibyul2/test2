package com.kosa.starrydonuts.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor // �??���?
public class AttacheFileDTO {

	// ?��?��
	private int fileNo; 			// 첨�??��?�� ?��?��?��
	private int boardid; 			// 게시�?번호
	private String fileNameOrg;		// ?��?��?���? ?���? ?���? ?��?���? 
	private String fileNameReal;	// ?��버에 ???��?�� ?��?���? 
	private int    length;			// ?��?��?�� 길이
	private String contentType;		// 컨텐�? ???��
	private Date   reg_date;		// ?��록일?��
	
} // AttacheFileDTO

