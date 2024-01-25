package kr.co.publicvoid.service;

public class PublisherService {
	public static final PublisherService INSTANCE = new PublisherService();

	private PublisherService() {}
	
	public static PublisherService getInstance() {
		return INSTANCE;
	}
	
	
}
