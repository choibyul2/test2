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
public class NoticeDTO {

	// �ʵ�
	private int pid;				// �Խñ� �θ��ȣ, �θ� ���� �� : 0
	private int noticeid; 			// �Խñ۹�ȣ
	private String title;			// ����
	private String contents = "";	// ����
	private String writer_uid;		// �۾���
	private Date reg_date;			// �ۼ���¥
	private Date mod_date;			// ������¥
	private int view_count;			// ��ȸ��
	private String delete_yn; 		// ��������
	private String N;				
	private String fixed_yn; 		// ��������
	private int level = 1;
	
	private String [] ids;         	// ������ ���� ���̵��
	
	//�˻��ʵ�
	private String searchTitle = "";
	
	//����¡�ʵ�
	private int pageNo = 1;     	// ���� ������ ��ȣ
	private int totalCount;     	// ��ü �Ǽ� (�Ǽ��� �־�� ������ �����..)
	private int totalPageSize;  	// ��ü �������� (���� ������ ����)
	private int pageLength = 10;	// �� �������� ������ �Խù� ����(ũ��)
	private int navSize = 10;   	// ������ �ϴܿ� ��µǴ� �������� �׸�� (���� 10���� ������)
	private int navStart = 0;   	// ������ �ϴܿ� ��µǴ� ������ ���� ��ȣ : NavStart = ((PageNo-1) / NavSize) * NavSize + 1
	private int navEnd = 0;     	// ������ �ϴܿ� ��µǴ� ������ �� ��ȣ : NavEnd = ((PageNo-1) / NavSize + 1) * NavSize
	
	
	// �� �ۼ� �� ����Ű ���� ���ִ� �޼���
	public String getContentsHTML() {
	
		return contents.replace("\n", "<br/>");
	} //getContentsHTML
	
	
	// ����¡ �޼���
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		//2. ��ü ������ �Ǽ��� ����Ѵ� 
		totalPageSize = (int) Math.ceil((double) totalCount / pageLength);
		
		//3. ������ �׺������ ���� �������� ����Ѵ�
		navStart = ((pageNo - 1) / navSize) * navSize + 1;
		
		//4. ������ �׺������ �� �������� ����Ѵ�
		navEnd = ((pageNo - 1) / navSize + 1) * navSize;
		
		//5. ��ü ������ ���� ũ�� ��ü ������ ���� �����Ѵ�
		if (navEnd >= totalPageSize) {
			navEnd = totalPageSize;
		}
		
	} //setTotalCount
	
	
	// �� �������� ���� ���� (���� 1, 11, 21, 31 ... )
	public int getStartNo() { 
	
		return (pageNo - 1) * pageLength + 1; 
	} //getStartNo
	
	// �� �������� �� ���� (���� 10, 20, 30... �̶� ���� �� ��������)
	public int getEndNo() { 
	
		return pageNo * pageLength; 
	} //getEndNo
	
	
} // end class
