package br.com.tide.input.controller;

import br.com.etyllica.core.event.KeyEvent;

public class JoystickOneController extends Controller{
		
	public JoystickOneController(){
		super();
		
		upButtonDown = KeyEvent.TSK_JOYSTICK_UP;
		
		upButtonUp = KeyEvent.TSK_JOYSTICK_CENTER_Y;
		
		downButtonDown = KeyEvent.TSK_JOYSTICK_DOWN;
		
		downButtonUp = KeyEvent.TSK_JOYSTICK_CENTER_Y;
		
		leftButtonDown = KeyEvent.TSK_JOYSTICK_LEFT;
		
		leftButtonUp = KeyEvent.TSK_JOYSTICK_CENTER_X;
		
		rightButtonDown = KeyEvent.TSK_JOYSTICK_RIGHT;
		
		rightButtonUp = KeyEvent.TSK_JOYSTICK_CENTER_X;
		
		ButtonA = KeyEvent.TSK_Z;
		
		ButtonB = KeyEvent.TSK_X;
		
		ButtonC = KeyEvent.TSK_C;
		
		startButton = KeyEvent.TSK_ENTER;
		
	}

}
