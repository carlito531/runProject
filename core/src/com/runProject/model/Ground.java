package com.runProject.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.runProject.box2d.GroundUserData;
import com.runProject.box2d.UserData;

public class Ground extends GameActor {

	public Ground(Body body) {
		super(body);
	}

	@Override
	public UserData getUserData() {
		return (GroundUserData) userData;
	}
}
