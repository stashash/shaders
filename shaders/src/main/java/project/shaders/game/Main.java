package project.shaders.game;

import project.shaders.engine.GameEngine;
import project.shaders.engine.IGameLogic;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			boolean vSync = true;
			IGameLogic gameLogic = new DummyGame();
			GameEngine gameEng = new GameEngine("GAMETEST", 600, 480, vSync, gameLogic);
			gameEng.start();
		} catch (Exception excp) {
			excp.printStackTrace();
			System.exit(-1);
		}

	}

}
