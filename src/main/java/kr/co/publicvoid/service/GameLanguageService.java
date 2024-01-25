package kr.co.publicvoid.service;

public class GameLanguageService {
	public static final GameLanguageService INSTANCE = new GameLanguageService();

	private GameLanguageService() {}
	
	public static GameLanguageService getInstance() {
		return INSTANCE;
	}
	
}
