package kr.co.publicvoid.service;

public class MemberItemService {
	public static final MemberItemService INSTANCE = new MemberItemService();

	private MemberItemService() {}
	
	public static MemberItemService getInstance() {
		return INSTANCE;
	}
	
	
}
