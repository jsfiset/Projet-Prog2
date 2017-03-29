
package Objects;

public class FroggerGame {

	
	public static final int PLAYING = 0, PLAYER_WINS = 2, MAX_LIFE_TIME = 50;
	public static boolean DEAD = false;
	public static boolean WIN = false;
	public static final int frogInitialX = 270, frogInitialY = 612;
	public static final int CarLaneInitialY = 370;
	public static final int waterLaneInitialY = 30;

	int status, lives, startLifeTime;
	boolean reachedMiddle;
	Frog frog;
	WaterLane[] waterLanes;
	RoadLane[] roadLanes;

	public FroggerGame() {
		status = FroggerGame.PLAYING;
		reachedMiddle = false;
		lives = 3;
		frog = new Frog();
		frog.move(frogInitialX, frogInitialY);
	
		// log and car lanes -------------
		roadLanes = new RoadLane[5];
		waterLanes = new WaterLane[5];

		int laneSpeed = 3;
		
		for (int i = 0; i < roadLanes.length; i++) {
			if (i % 2 == 0)
			{
				waterLanes[i] = new WaterLane(laneSpeed, "RIGHT", CarLaneInitialY + i * 55);
				roadLanes[i] = new RoadLane(laneSpeed, "RIGHT", CarLaneInitialY + i * 55);
			}
			else
			{
				waterLanes[i] = new WaterLane(laneSpeed, "LEFT", CarLaneInitialY + i * 55);
			    roadLanes[i] = new RoadLane(laneSpeed, "LEFT", CarLaneInitialY + i * 55);
			}
		}



		for (int t = 0; t < 1000; t++) // calls update on all lanes before
										// loading game
			update();
	}

	void update() {
		// todo moves cars logs turtles, calls runChecks >help
		for (int u = 0; u < roadLanes.length; u++)
			roadLanes[u].update();
		for (int y = 0; y < roadLanes.length; y++)
			runChecks();
	}

	public int getStatus() {
		return status;
	}

	public int getLives() {
		return lives;
	}

	public Frog getFrog() {
		return frog;
	}

	

	public int getTimeLeft() {
		return MAX_LIFE_TIME - startLifeTime;
	}

	void playerDeath() {
		lives--;
		if (lives > 0) {
			frog.move(frogInitialX, frogInitialY);
		} else {
			DEAD = true;
		}
	}

	//void carCheck() {
		// todo kills player when contacting car{
//		if (CollisionDetector.CollisionDetector(this.getPlayer(), this.getCarLanes())) {
//			playerDeath();
//		}
	//}

	void logCheck() {
		// todo moves player if on log with log, otherwise kills
	}

	void turtleCheck() {
		// todo moves player with non-down turtle, otherwise kills
	}


	void checkifThePlayerWin() {
		if (this.frog.getY() > 500) {
			WIN = true;
		}
	}

	void runChecks() {
		//carCheck();
		checkifThePlayerWin();

	}

}
