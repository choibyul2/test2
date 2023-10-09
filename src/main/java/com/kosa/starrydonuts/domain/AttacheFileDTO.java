package com.kosa.starrydonuts.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor // ê¸??“°ê¸?
public class AttacheFileDTO {

	// ?•„?“œ
	private int fileNo; 			// ì²¨ë??ŒŒ?¼ ?•„?´?””
	private int boardid; 			// ê²Œì‹œê¸?ë²ˆí˜¸
	private String fileNameOrg;		// ?‚¬?š©?ê°? ?˜¬ë¦? ?›ë³? ?ŒŒ?¼ëª? 
	private String fileNameReal;	// ?„œë²„ì— ???¥?œ ?ŒŒ?¼ëª? 
	private int    length;			// ?ŒŒ?¼?˜ ê¸¸ì´
	private String contentType;		// ì»¨í…ì¸? ???…
	private Date   reg_date;		// ?“±ë¡ì¼?‹œ
	
} // AttacheFileDTO

