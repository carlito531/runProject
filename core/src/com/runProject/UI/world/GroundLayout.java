package com.runProject.UI.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.runProject.box2d.GroundUserData;
import com.runProject.common.Constants;

public class GroundLayout {
	
		public GroundLayout() {
		}
		
		public Body createGround(World world) {
			
		 	BodyDef bodyDef = new BodyDef();
	        bodyDef.position.set(new Vector2(Constants.GROUND_X, Constants.GROUND_Y));
	        Body body = world.createBody(bodyDef);
	        PolygonShape shape = new PolygonShape();
	        shape.setAsBox(Constants.GROUND_WIDTH / 2, Constants.GROUND_HEIGHT / 2);
	        body.createFixture(shape, Constants.GROUND_DENSITY);
	        body.setUserData(new GroundUserData(Constants.GROUND_WIDTH, Constants.GROUND_HEIGHT));
	        shape.dispose();
	        
	        return body;
		}		
}
