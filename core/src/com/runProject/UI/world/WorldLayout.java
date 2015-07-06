package com.runProject.UI.world;

import com.badlogic.gdx.physics.box2d.World;
import com.runProject.common.Constants;

public class WorldLayout {

	public WorldLayout() {
	}
	
	public World createWorld() {
		return new World(Constants.WORLD_GRAVITY, true);
	}
	
}
