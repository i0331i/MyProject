모듈화 프로그래밍
=======================
모듈화란?
----------------
기능별로 파일을 나눠가며 프로그래밍하는 것
 
 장점:**유지 보수** 하기에 좋다
 
 모듈화를 적용시킨 코드
 -------------------------------

 ~~~java
 public List<EntityVO> getEntityInfo() throws IllegalArgumentException, IllegalAccessException {  
 		  
	List<EntityVO> list = new ArrayList<EntityVO>();  
		try {  
 			list = select();  
		} catch (SQLException e) {  
			e.printStackTrace();  
 	        }  
		if(list == null) {	 
			updateWebtoon();  
	        }  
		System.out.println("실행중");  
	        return list;  
	        }   //select 메소드를 실행시킨 후 값을 jsp에 저장
  
  public List<EntityVO> whileRs(ResultSet rs) throws IllegalArgumentException, IllegalAccessException {
	
	List<EntityVO> list = new ArrayList<EntityVO>();
		try {
		while(rs.next()) {
			list.add(getReusltSet(rs));	
		 } catch (SQLException e) {
			e.printStackTrace();
                 }
	           return list;
	         }
  
  public EntityVO getReusltSet(ResultSet rs) throws SQLException, IllegalArgumentException, IllegalAccessException {
	
	EntityVO ob = new EntityVO();
		for(Field f : ob.getClass().getDeclaredFields()) { 
			f.setAccessible(true);	
			String name = f.getName();	
			f.set(ob, rs.getString(name));	
		}
		return ob;
		}
  
  
  getResultSet:DB값을 VO에 세팅을 해주는 역할을 함.
  getDeclaredFields:VO클래스의 필드명과 변수명을 가져오는 역할을 함.
  
  아직 모듈화가 익숙치 않은 것 같아 더 열심히 연습하겠습니다...ㅠㅜ
  
  
