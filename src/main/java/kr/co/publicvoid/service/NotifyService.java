package kr.co.publicvoid.service;

public class NotifyService {
	public static final NotifyService INSTANCE = new NotifyService();

	private NotifyService() {}
	
	public static NotifyService getInstance() {
		return INSTANCE;
	}
	
}
