package com.spring.lsy0911;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	//getInstance() -> sqlMapper 인스턴스가 할당이 안되었다면, 초기화 작업
	// 인스턴스에 구성요소 
	// 1) 디비에 연결하기위한 환경 변수 , 서버주소, 드라이버, 계정, 패스워드 
	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

	// 과제 연습, selectAllMemberList : 단순 디비의 내용을 조회.
	// selectAllMemberList() , 이 메서드는 매개변수 없고, 
	// 반환은 모델 클래스 MemberVO 타입을 요소로 가지는 리스트 형. 
	public List<MemberVO> selectAllMemberList() {
		//getInstance() 위에서 정의한, 디비에 연결하기 위한 인스턴스(수납도구)
		sqlMapper = getInstance();
		// session -> sql 문장을 이용해서, db 조작을 위한 인스턴스 
		SqlSession session = sqlMapper.openSession();
		// 임시로 담을 리스트형의 인스턴스 
		List<MemberVO> memlist = null;
		// 실제, 디비에서 , 데이터를 가지고 와서 담을 변수. -- 실제 작업. 
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
	
	
	//과제 
	public List<MemberVO> selectAllMemberList2() {
		//getInstance() 위에서 정의한, 디비에 연결하기 위한 인스턴스(수납도구)
		sqlMapper = getInstance();
		// session -> sql 문장을 이용해서, db 조작을 위한 인스턴스 
		SqlSession session = sqlMapper.openSession();
		// 임시로 담을 리스트형의 인스턴스 
		List<MemberVO> memlist = null;
		// 실제, 디비에서 , 데이터를 가지고 와서 담을 변수. -- 실제 작업. 
		memlist = session.selectList("mapper.member.selectAllMemberList2");
		return memlist;
	}
	
	
//	 public List<HashMap<String, String>> selectAllMemberList() { 
//		sqlMapper = getInstance(); 
//     	SqlSession session = sqlMapper.openSession();
//		List<HashMap<String, String>> memlist = null; 
//   	memlist = session.selectList("mapper.member.selectAllMemberList"); 
//		return memlist; 
//	 }
	
}
