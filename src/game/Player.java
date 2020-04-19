package game;
import java.awt.Color;

import sedgewick.ArcadeKeys;
import sedgewick.StdDraw;

public class Player {
		
		private double posX;
		private double posY; 
		public double velocityX;
		public double velocityY;
		private final double startPosX;
		private final double startPosY;
		private final double width = 0.1;
		private final double height = 0.1;
		private int player;
		private int score;


		public Player(double x, double y, int player) {
			this.posX = x;
			this.posY = y;
			this.startPosX = x;
			this.startPosY = y;
			this.player = player;
		}
		/**
		 * gets the score of the player
		 * @return the points the player has
		 */
		public int getScore() {
			updateScore();
			return this.score;
		}
		/**
		 * sets the score (for testing purposes)
		 */
		
		public void setScore(int score) {
			this.score = score;
		}
		/**
		 * Updates the score based on the players position
		 */	
		public void updateScore() {
//			if(determinePlayer() == "Left Player") {
//				if(this.posX <= -1.5 && this.posX >= -1.55) {
//					score += 1;
//				}
//			}
//			if(determinePlayer() == "Right Player") {
//				if(this.posX >= 1.5) {
//					score += 1;
//				}
			//}
			if(this.posX <= -1.5 && this.posX >= -1.55) {
				score += 1;
			}
			if(this.posX >= 1.5) {
				score += 1;
			}
			
		}
		
		/**
		 * draws players
		 */
		public void draw() {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
		}
		/**
		 * movement of each player depending on which keys are pressed.
		 */
		//change it so that it takes in a button press
		public void move() {
		
			//player movement with constraints of the boundaries of the field
//			if (determinePlayer() == "Left Player"){
//				moveLeftPlayer(buttonPressed());
//			}
//			if (determinePlayer() == "Right Player"){
//				moveRightPlayer(buttonPressed());
//			}
			if (determinePlayer() == "Left Player"){
				if ((ArcadeKeys.isKeyPressed(0, 1)) && this.posX>-2) {
					//key pressed changes velocity
					this.velocityX -= 0.01;
				}
				if ((ArcadeKeys.isKeyPressed(0, 3)) && this.posX<-0.1) {
					this.velocityX += 0.01;
				}
				if ((ArcadeKeys.isKeyPressed(0, 0)) && this.posY <= -0.95) {
					//a jump starts you off at a fixed velocity, if you are currently on the ground
					this.velocityY = 0.1;
		
				}
			}
			if (determinePlayer() == "Right Player"){
				if ((ArcadeKeys.isKeyPressed(1, 1)) && this.posX > 0.1) {
					//key pressed changes velocity
					this.velocityX -= 0.01;
				}
				if ((ArcadeKeys.isKeyPressed(1, 3)) && this.posX < 2) {
					this.velocityX += 0.01;
				}
				if ((ArcadeKeys.isKeyPressed(1, 0)) && this.posY <= -0.95) {
					//a jump starts you off at a fixed velocity, if you are currently on the ground
					this.velocityY = 0.1;
				}
			}
			//velocities update the position
			updatePosition();
			
		}
		/**
		 * determines the player based on the when it was initalized
	     * @return String of the whether it is left player or right player
		*/
		
		public String determinePlayer() {
			if(player == 0) {
				return "Left Player";
			}else if(player == 1) {
				return "Right Player";
			}
			return "Invalid Player";
		}
		/**
		 * Determines how to move left player based on button pressed and posX or posY 
	     * @param indication of which button was pressed
		*/
		
		public void moveLeftPlayer(String buttonPressed) {
			if ((buttonPressed == "a") && this.posX>-2) {
				//key pressed changes velocity
				this.velocityX -= 0.01;
			}
			if ((buttonPressed == "d") && this.posX<-0.1) {
				this.velocityX += 0.01;
			}
			if ((buttonPressed == "w") && this.posY <= -0.95) {
				//a jump starts you off at a fixed velocity, if you are currently on the ground
				this.velocityY = 0.1;
	
			}
		}
		/**
		 * Determines how to move right player based on button pressed and posX or posY 
	     * @param indication of which button was pressed
		*/
		public void moveRightPlayer(String buttonPressed) {
			if ((buttonPressed == "left")  && this.posX > 0.1) {
				//key pressed changes velocity
				this.velocityX -= 0.01;
			}
			if ((buttonPressed == "right") && this.posX < 2) {
				this.velocityX += 0.01;
			}
			if ((buttonPressed == "up") && this.posY <= -0.95) {
				//a jump starts you off at a fixed velocity, if you are currently on the ground
				this.velocityY = 0.1;
			}
			
		}
		/**
		 * updates the position of a player by adding to its x position and y position and sets x and y velocity
	     * @param indication of which button was pressed
		*/
		
		public void updatePosition() {
			this.posX += this.velocityX;
			this.posY += this.velocityY;
			updateVelocity(this.posY);
		}
		
		/**
		 * updates the x velocity and updates the y velocity based on y position.
	     * @param the current y position
		*/
		
		public void updateVelocity(double posY) {
			if(posY > -0.95) {
				this.velocityY = this.velocityY - 0.0000005;
			}
			
			this.velocityX = 0;
			
		}
		
		/**
		 * updates the x velocity and updates the y velocity based on y position.
	     * @return a String indication which key was pressed
		*/
		public String buttonPressed() {
			if(ArcadeKeys.isKeyPressed(0, 1)) {
				return "a";
			}
			if((ArcadeKeys.isKeyPressed(0, 3))) {
				return "d";
			}
			if((ArcadeKeys.isKeyPressed(0, 0))) {
				return "w";
			}
			if((ArcadeKeys.isKeyPressed(1, 1))) {
				return "left";
			}
			if((ArcadeKeys.isKeyPressed(1, 3))){
				return "right";
			}
			if((ArcadeKeys.isKeyPressed(1, 0))){
				return "up";
			}
			return "not valid button";
		}

		/**
		 * get's the current x position
		*/
		public double getPosX() {
			return this.posX;
		}
		/**
		 * get's the current y position
		*/
		public double getPosY() {
			return this.posY;
		}
		/**
		 * get's the current x velocity
		*/
		public double getvelocityX() {
			return this.velocityX;
		}
		/**
		 * get's the current y velocity
		*/
		public double getvelocityY() {
			return this.velocityY;
		}
		/**
		 * updates the y velocity to act in a way of gravity.
		*/
		public void gravity() {
			this.velocityY = this.velocityY - 0.005;
		}
		
		
}