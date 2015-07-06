package com.runProject;

import com.badlogic.gdx.Game;
import com.runProject.UI.MainLayout;

public class RunProject extends Game {
	
	@Override
	public void create () {
		this.setScreen(new MainLayout());
	}

}
