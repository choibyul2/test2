package com.kosa.starrydonuts.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

      private String commentid;   // �ڸ�Ʈ ���̵�
      private int boardid;      	// ������ �������� ���̵�
      private String writer_uid;      // �ۼ���
      private String contents;      // ��� ����
      private Date reg_date;      // �ۼ���¥
      private Date update_date;   // ������¥

} // end class
