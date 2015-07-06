package com.runProject.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.runProject.UI.stages.MainStage;

public class MainLayout implements Screen {

	private MainStage mainStage = null;
	
	public MainLayout() {
		mainStage = new MainStage();
	}
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		//Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the stage
        mainStage.draw();
        mainStage.act(delta);	
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

}
