package com.runProject.UI.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.runProject.box2d.EnemyUserData;
import com.runProject.enums.EnemyType;
import com.runProject.utils.EnemyUtils;

public class EnemyLayout {
	
	public EnemyLayout() {
	}
	
	public Body createEnemy(World world) {
		
		EnemyType enemyType = EnemyUtils.getRandomEnemyType();
	    BodyDef bodyDef = new BodyDef();
	    bodyDef.type = BodyDef.BodyType.KinematicBody;
	    bodyDef.position.set(new Vector2(enemyType.getX(), enemyType.getY()));
	    PolygonShape shape = new PolygonShape();
	    shape.setAsBox(enemyType.getWidth() / 2, enemyType.getHeight() / 2);
	    Body body = world.createBody(bodyDef);
	    body.createFixture(shape, enemyType.getDensity());
	    body.resetMassData();
	    EnemyUserData userData = new EnemyUserData(enemyType.getWidth(), enemyType.getHeight());
	    body.setUserData(userData);
	    shape.dispose();
	    
	    return body;
	}
	
}
