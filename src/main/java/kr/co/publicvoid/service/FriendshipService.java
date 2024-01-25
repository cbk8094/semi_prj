package kr.co.publicvoid.service;

public class FriendshipService {
	public static final FriendshipService INSTANCE = new FriendshipService();

	private FriendshipService() {}
	
	public static FriendshipService getInstance() {
		return INSTANCE;
	}
	
}
