package com.runProject.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.runProject.box2d.EnemyUserData;
import com.runProject.box2d.UserData;

public class Enemy extends GameActor {

	public Enemy(Body body) {
       super(body);
    }
	
	@Override
	public UserData getUserData() {
		//return (EnemyUserData) userData;
		return userData;
	}
	
	@Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(((EnemyUserData) getUserData()).getLinearVelocity());
    }
}
