package kr.co.publicvoid.service;

// 수정. 자동으로 rollback()이 이뤄지지 않는다.
// 일반적으로 메서드 내에서 일일이 필요한 SqlSession을 열고 트랜잭션을 관리하며 해당 세션으로 mapper를 가져오는 것이 권장된다.
public class BoardFileService {
	// 모든 서비스를 싱글턴으로 만든다
	public static final BoardFileService INSTANCE = new BoardFileService();
	private BoardFileService() {
        // private 생성자로 외부에서 직접 인스턴스 생성을 막음
    }

    public static BoardFileService getInstance() {
        return INSTANCE;
    }
	
}
