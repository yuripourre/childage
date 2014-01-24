package br.com.tide.input.controller;

import br.com.etyllica.core.event.KeyEvent;

public class JoystickOneController extends Controller{
		
	public JoystickOneController(){
		super();
		
		upButton = KeyEvent.TSK_JOYSTICK_UP;
		
		downButton = KeyEvent.TSK_JOYSTICK_DOWN;
		
		leftButton = KeyEvent.TSK_JOYSTICK_LEFT;
		
		rightButton = KeyEvent.TSK_JOYSTICK_RIGHT;
		
		ButtonA = KeyEvent.TSK_Z;
		
		ButtonB = KeyEvent.TSK_X;
		
		ButtonC = KeyEvent.TSK_C;
		
		startButton = KeyEvent.TSK_ENTER;
		
	}

}
