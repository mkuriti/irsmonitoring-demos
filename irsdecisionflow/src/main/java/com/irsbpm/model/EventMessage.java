package com.irsbpm.model;

import com.irsbpm.main.IRSBPMDecision;

public class EventMessage {

	public static final int DONE = 0;
	public static final int RUP = 1;
	public static final int EUP = 2;
	public static final int MEF = 3;
	public static final int AIR = 4;
	public static final int CADE = 5;
	public static final int MFOL = 6;
	public static final int IDRS = 7;
	public static final int CFOL = 8;
	public static final int RRP = 9;
    public static final int AUR = 10;
	public static final int MEF2 = 11;
	public static final int CADE2 = 12;
	public static final int MFOL2 = 13;
	public static final int MFOL3 = 14;
	public static final int MFOL4 = 15;
    
	public String id;
	public String name;
	public String message;
	public int status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
		IRSBPMDecision.actionMessage(message);
	}

	public String getMessage() {
		return this.message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
}
