package com.runProject.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.runProject.box2d.UserData;
import com.runProject.box2d.RunnerUserData;

public class Runner extends GameActor {

	private boolean jumping;
	
	public Runner(Body body) {
		super(body);
	}
	
	@Override
	public UserData getUserData() {
		//return (RunnerUserData) userData;
		return userData;
	}
	
	public void jump() {

        if (!jumping) {
            body.applyLinearImpulse(((RunnerUserData) this.getUserData()).getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }
    }

    public void landed() {
        jumping = false;
    }
}
