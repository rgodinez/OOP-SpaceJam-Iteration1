package model.occupation;

import model.items.equipment.EquipmentBuilder;
import model.slots.Equipment;
import model.stats.factory.OrcTerminatorFactory;
import model.stats.factory.StatFactory;
import utilities.SpriteSheetUtility;

public class SkeletonAlchemist extends Alchemist{
	
	protected StatFactory getStatFactory(Equipment equipment){
		return new OrcTerminatorFactory(equipment);
	}
	public Equipment createEquipment(EquipmentBuilder eb){
		return eb.buildEquipmentAlchemistNPC(this);
	}
	public SpriteSheetUtility getSpriteSheet(){
		return new SpriteSheetUtility(this);
	}

}
