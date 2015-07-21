package com.runProject;

import com.badlogic.gdx.Game;
import com.runProject.UI.HomeScreen;

public class RunProject extends Game {
	
	@Override
	public void create () {
		this.setScreen(new HomeScreen(this));
	}
	
	public void render() {
		super.render();
	}

	public void dispose() {
	}

}
