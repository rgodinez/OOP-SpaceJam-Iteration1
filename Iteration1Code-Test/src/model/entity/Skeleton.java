package model.entity;

import model.behavior.PickPockit;
import model.occupation.SkeletonAlchemist;

public class Skeleton extends NPC implements Conversable {
	
	public Skeleton() {
		super(new SkeletonAlchemist());
		this.engagedState.setState(new PickPockit());
	}

	@Override
	public String getDialogue() {
		// TODO Auto-generated method stub
		return "Skeleton: I'M A SCARY SKELETON RAAWWRRR";
	}
	
	public String toString() {
		return "NPC:Skeleton";
	}

}