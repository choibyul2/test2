package com.kosa.starrydonuts.dao;

import java.util.List;

import com.kosa.starrydonuts.domain.CommentDTO;

public interface CommentDAO {

	  //1. ´ñ±Û ÀÛ¼ºÇÏ±â
	  public boolean commentInsert(CommentDTO comment) throws Exception;
	  
	  //2. ´ñ±Û ¸ñ·Ï
	  public List<CommentDTO> commentList(CommentDTO comment) throws Exception;
	  
	  //3. ´ñ±Û ¼öÁ¤ÇÏ±â
	  public boolean commentUpdate(CommentDTO comment) throws Exception;
	  
	  //4. ´ñ±Û »èÁ¦ÇÏ±â
	  public boolean commentDelete(CommentDTO comment) throws Exception;

}
