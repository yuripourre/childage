package br.com.tide.input.controller;

import br.com.etyllica.core.event.KeyEvent;

public class Controller {

	protected int upButtonDown = KeyEvent.TSK_UP_ARROW;
	
	protected int downButtonDown = KeyEvent.TSK_DOWN_ARROW;
	
	protected int leftButtonDown = KeyEvent.TSK_LEFT_ARROW;
	
	protected int rightButtonDown = KeyEvent.TSK_RIGHT_ARROW;
	
	protected int upButtonUp = KeyEvent.TSK_UP_ARROW;
	
	protected int downButtonUp = KeyEvent.TSK_DOWN_ARROW;
	
	protected int leftButtonUp = KeyEvent.TSK_LEFT_ARROW;
	
	protected int rightButtonUp = KeyEvent.TSK_RIGHT_ARROW;
	
	protected int ButtonA = KeyEvent.TSK_Z;
	
	protected int ButtonB = KeyEvent.TSK_X;
	
	protected int ButtonC = KeyEvent.TSK_C;
	
	protected int startButton = KeyEvent.TSK_ENTER;
	
	public Controller(){
		super();
	}
	
	public int getUpButtonDown() {
		return upButtonDown;
	}

	public void setUpButtonDown(int upButtonDown) {
		this.upButtonDown = upButtonDown;
	}

	public int getDownButtonDown() {
		return downButtonDown;
	}

	public void setDownButtonDown(int downButtonDown) {
		this.downButtonDown = downButtonDown;
	}

	public int getLeftButtonDown() {
		return leftButtonDown;
	}

	public void setLeftButtonDown(int leftButtonDown) {
		this.leftButtonDown = leftButtonDown;
	}

	public int getRightButtonDown() {
		return rightButtonDown;
	}

	public void setRightButtonDown(int rightButtonDown) {
		this.rightButtonDown = rightButtonDown;
	}

	public int getUpButtonUp() {
		return upButtonUp;
	}

	public void setUpButtonUp(int upButtonUp) {
		this.upButtonUp = upButtonUp;
	}

	public int getDownButtonUp() {
		return downButtonUp;
	}

	public void setDownButtonUp(int downButtonUp) {
		this.downButtonUp = downButtonUp;
	}

	public int getLeftButtonUp() {
		return leftButtonUp;
	}

	public void setLeftButtonUp(int leftButtonUp) {
		this.leftButtonUp = leftButtonUp;
	}

	public int getRightButtonUp() {
		return rightButtonUp;
	}

	public void setRightButtonUp(int rightButtonUp) {
		this.rightButtonUp = rightButtonUp;
	}

	public int getButtonA() {
		return ButtonA;
	}

	public void setButtonA(int buttonA) {
		ButtonA = buttonA;
	}

	public int getButtonB() {
		return ButtonB;
	}

	public void setButtonB(int buttonB) {
		ButtonB = buttonB;
	}

	public int getButtonC() {
		return ButtonC;
	}

	public void setButtonC(int buttonC) {
		ButtonC = buttonC;
	}

	public int getStartButton() {
		return startButton;
	}

	public void setStartButton(int startButton) {
		this.startButton = startButton;
	}
		
}
