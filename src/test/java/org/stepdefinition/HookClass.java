package org.stepdefinition;

import org.bas.Baseclass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookClass extends Baseclass {

	@Before(order=1)
	//precondition
	private void precondition2() {
		launchBrowser();
		System.out.println("launch the browser");

	}
	@Before(order=2)
	//precondition
	private void precondition1() {
		
		windowMaximize();
		System.out.println("max the window");

	}
	@Before(order=3,value="@sanity")
	//precondition
	private void precondition3() {
		System.out.println("precondition 3");

	}
	@After(order=10,value="@sanity")
	//postcondition
	private void postcondition2() {
		System.out.println("take the scanrio sceenshoot");

	}
	@After(order=4)
	//postcondition
	private void postcondition1() {
		CloseEntireBrowser();
		System.out.println("close the browser");

	}
	
	
}
