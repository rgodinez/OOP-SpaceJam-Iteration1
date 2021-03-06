package model;

import java.awt.image.BufferedImage;

public class SkullAndCrossbonesDecal extends Decal {

	public SkullAndCrossbonesDecal() {
		super();
		this.decalID = 'X';
	}
	
	// fix this constructor later
	public SkullAndCrossbonesDecal(AreaEffect effect){
		super();
		this.effect=effect;
		this.decalID = 'X';
	}
	/*
	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "src/res/img/skullandcrossbones_decal.png";
	}
	*/
	
	public BufferedImage getImage(int scale){
		return DecalImageProxy.getDecalImage(this);
	}
	public BufferedImage getNewImage(){
		return DecalImageProxy.getNewDecalImage(this);
	}
	
	public String toString() {
		return "Decal:X\n" + this.effect;
	}
}