package kr.co.publicvoid.service;

public class ItemImageService {
	public static final ItemImageService INSTANCE = new ItemImageService();
	
	private ItemImageService() {}
	
	public static ItemImageService getInstance() {
		return INSTANCE;
	}
	
	
}
