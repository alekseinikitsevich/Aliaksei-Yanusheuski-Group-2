package com.alex.myapp;

public class MyApp implements IMyApp {

	private String firstCode;
	private String secondCode;
	private String thirdCode;
	private String fourthCode;

	public MyApp() {

		firstCode = "5A12X3P";
		secondCode = "2D3G21F";
		thirdCode = "7W3C21N";
		fourthCode= "3KFMV98";
	}

	@Override
	public String getCode(String id) {
		switch (id) {
		case "1":
			return firstCode;
		case "2":
			return secondCode;
		case "3":
			return thirdCode;
		case "4":
			return fourthCode;
		default:

			return "Wrong Code Number";
		}
	}

}
