package com.runProject.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.runProject.box2d.UserData;
import com.runProject.box2d.RunnerUserData;

public class Runner extends GameActor {

	private boolean jumping;
	private boolean dodging;
	private boolean hit;
	
	public Runner(Body body) {
		super(body);
	}
	
	@Override
	public UserData getUserData() {
		//return (RunnerUserData) userData;
		return userData;
	}
	
	public void jump() {

		if (!(jumping || dodging)) {
            body.applyLinearImpulse(((RunnerUserData) getUserData()).getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }
    }

    public void landed() {
        jumping = false;
    }
    
    public void dodge() {
        if (!jumping) {
            body.setTransform(((RunnerUserData) getUserData()).getDodgePosition(), ((RunnerUserData) getUserData()).getDodgeAngle());
            dodging = true;
        }
    }

    public void stopDodge() {
        dodging = false;
        body.setTransform(((RunnerUserData) getUserData()).getRunningPosition(), 0f);
    }

    public boolean isDodging() {
        return dodging;
    }
    
    public void hit() {
        body.applyAngularImpulse(((RunnerUserData) getUserData()).getHitAngularImpulse(), true);
        hit = true;
    }

    public boolean isHit() {
        return hit;
    }
}
