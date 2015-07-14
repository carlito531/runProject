package com.runProject.common;

import com.badlogic.gdx.math.Vector2;

public class Constants {
	
	/* screen size */
	public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;
	
    /* world generation */
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);
    public static final float GROUND_X = 0F;
    public static final float GROUND_Y = 0F;
	public static final float GROUND_WIDTH = 50F;
	public static final float GROUND_HEIGHT = 2F;
	public static final float GROUND_DENSITY = 0F;
	
	/* runner */
	public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1F;
    public static final float RUNNER_HEIGHT = 2F;
    public static float RUNNER_DENSITY = 0.5F;
    
    /* runner actions */
    
    // Jump
    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 13f);
    
    // Dodge
    public static final float RUNNER_DODGE_X = 2f;
    public static final float RUNNER_DODGE_Y = 1.5f;
    
    // Hit
    public static final float RUNNER_HIT_ANGULAR_IMPULSE = 10f;
    
    /* Ennemies */
    public static final float ENEMY_X = 25f;
    public static final float ENEMY_DENSITY = RUNNER_DENSITY;
    public static final float RUNNING_SHORT_ENEMY_Y = 1.5f;
    public static final float RUNNING_LONG_ENEMY_Y = 2f;
    public static final float FLYING_ENEMY_Y = 3f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);
    
}
