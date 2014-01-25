package br.com.tide.input.controller;

import br.com.etyllica.core.event.KeyEvent;

public class FirstPlayerController extends Controller{
		
	public FirstPlayerController(){
		super();
		
		upButtonDown = KeyEvent.TSK_W;
		
		upButtonUp = KeyEvent.TSK_W;
		
		downButtonDown = KeyEvent.TSK_S;
		
		downButtonUp = KeyEvent.TSK_S;
		
		leftButtonDown = KeyEvent.TSK_A;
		
		leftButtonUp = KeyEvent.TSK_A;
		
		rightButtonDown = KeyEvent.TSK_D;
		
		rightButtonUp = KeyEvent.TSK_D;
		
		ButtonA = KeyEvent.TSK_H;
		
		ButtonB = KeyEvent.TSK_J;
		
		ButtonC = KeyEvent.TSK_K;
		
		startButton = KeyEvent.TSK_F;
		
	}

}
