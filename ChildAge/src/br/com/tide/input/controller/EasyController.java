package br.com.tide.input.controller;

import br.com.etyllica.core.event.KeyEvent;

public class EasyController extends Controller{
		
	public EasyController(){
		super();
		
		upButtonDown = KeyEvent.TSK_UP_ARROW;
		
		upButtonUp = KeyEvent.TSK_UP_ARROW;
		
		downButtonDown = KeyEvent.TSK_DOWN_ARROW;
		
		downButtonUp = KeyEvent.TSK_DOWN_ARROW;
		
		leftButtonDown = KeyEvent.TSK_LEFT_ARROW;
		
		leftButtonUp = KeyEvent.TSK_LEFT_ARROW;
		
		rightButtonDown = KeyEvent.TSK_RIGHT_ARROW;
		
		rightButtonUp = KeyEvent.TSK_RIGHT_ARROW;
		
		ButtonA = KeyEvent.TSK_SHIFT_DIREITA;
		
		ButtonB = KeyEvent.TSK_CTRL_DIREITA;
		
		ButtonC = KeyEvent.TSK_M;
		
		startButton = KeyEvent.TSK_ENTER;
		
	}

}
