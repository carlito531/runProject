package com.runProject.UI.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.runProject.UI.world.BodyLayout;
import com.runProject.UI.world.GroundLayout;
import com.runProject.UI.world.RunnerLayout;
import com.runProject.UI.world.WorldLayout;
import com.runProject.model.Ground;
import com.runProject.model.Runner;

public class MainStage extends Stage implements ContactListener {
	
	 	private static final int VIEWPORT_WIDTH = 20;
	    private static final int VIEWPORT_HEIGHT = 13;

	    private World world;
	    private Ground ground;
	    private Runner runner;
	    
	    WorldLayout worldLayout = null;
	    GroundLayout groundLayout = null;
    	RunnerLayout runnerLayout = null;

	    private final float TIME_STEP = 1 / 300f;
	    private float accumulator = 0f;

	    private Rectangle screenRightSide;
	    private Rectangle screenLeftSide;
	    private Vector3 touchPoint;
	    
	    private OrthographicCamera camera;
	    private Box2DDebugRenderer renderer;

	    public MainStage() {
	    	worldLayout = new WorldLayout();
	 	    groundLayout = new GroundLayout();
	     	runnerLayout = new RunnerLayout();
	    	
	    	this.setupWorld();
	    	this.setupCamera();
	    	this.setupTouchControlAreas();
	        renderer = new Box2DDebugRenderer();
	    }
	    
	    private void setupWorld() {
	        world = worldLayout.createWorld();
	        world.setContactListener(this);
	        this.setupGround();
	        this.setupRunner();
	    }
	    
	    private void setupGround() {
	        ground = new Ground(groundLayout.createGround(world));
	        this.addActor(ground);
	    }

	    private void setupRunner() {
	        runner = new Runner(runnerLayout.createRunner(world));
	        this.addActor(runner);
	    }

	    private void setupCamera() {
	        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
	        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
	        camera.update();
	    }
	    
	    private void setupTouchControlAreas() {
	        touchPoint = new Vector3();
	        screenRightSide = new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
	        screenLeftSide = new Rectangle(0, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
	        Gdx.input.setInputProcessor(this);
	    }
	    
	    @Override
	    public boolean touchDown(int x, int y, int pointer, int button) {

	    this.translateScreenToWorldCoordinates(x, y);

		    if (rightSideTouched(touchPoint.x, touchPoint.y)) {
	            runner.jump();
	        } else if (leftSideTouched(touchPoint.x, touchPoint.y)) {
	            runner.dodge();
	        }
	        return super.touchDown(x, y, pointer, button);
	    }
	    
	    @Override
	    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

	        if (runner.isDodging()) {
	            runner.stopDodge();
	        }
	        return super.touchUp(screenX, screenY, pointer, button);
	    }

	    private boolean rightSideTouched(float x, float y) {
	        return screenRightSide.contains(x, y);
	    }
	    
	    private boolean leftSideTouched(float x, float y) {
	        return screenLeftSide.contains(x, y);
	    }
   
	    private void translateScreenToWorldCoordinates(int x, int y) {
	        this.getCamera().unproject(touchPoint.set(x, y, 0));
	    }
   
	    @Override
	    public void act(float delta) {
	        super.act(delta);

	        // Fixed timestep
	        accumulator += delta;

	        while (accumulator >= delta) {
	            world.step(TIME_STEP, 6, 2);
	            accumulator -= TIME_STEP;
	        }
	    }

	    /* Draw the scene with camera and world parameters */
	    @Override
	    public void draw() {
	        super.draw();
	        renderer.render(world, camera.combined);
	    }

		@Override
		public void beginContact(Contact contact) {
			Body a = contact.getFixtureA().getBody();
	        Body b = contact.getFixtureB().getBody();
	        
	        BodyLayout bodyLayout = new BodyLayout();
	        
	        if ((bodyLayout.bodyIsRunner(a) && bodyLayout.bodyIsGround(b)) || (bodyLayout.bodyIsGround(a) && bodyLayout.bodyIsRunner(b))) {
	            runner.landed();
	        }
		}

		@Override
		public void endContact(Contact contact) {
		}

		@Override
		public void preSolve(Contact contact, Manifold oldManifold) {
		}

		@Override
		public void postSolve(Contact contact, ContactImpulse impulse) {
		}
}
