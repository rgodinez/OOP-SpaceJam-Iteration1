package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import utilities.ImageProcessing;
import utilities.Scaling;
import model.ArmorSlot;
import model.BufferSlot;
import model.Equipment;
import model.ItemImageVisitor;
import model.Point;

public class EquipmentView extends JComponent{
	private static final Point POINT_OF_WEAPON = new Point(Scaling.EQUIPMENT_WEAPON_X,Scaling.EQUIPMENT_WEAPON_Y);
	private static final Point POINT_OF_ARMOR = new Point(Scaling.EQUIPMENT_ARMOR_X,Scaling.EQUIPMENT_ARMOR_Y);
	private static final Point POINT_OF_HELMET = new Point(Scaling.EQUIPMENT_HELMET_X, Scaling.EQUIPMENT_HELMET_Y);
	private static final Point POINT_OF_GLOVES = new Point(Scaling.EQUIPMENT_GLOVES_X, Scaling.EQUIPMENT_GLOVES_Y);
	private static final Point POINT_OF_LEGGINGS = new Point(Scaling.EQUIPMENT_LEGGINGS_X, Scaling.EQUIPMENT_LEGGINGS_Y);
	private static final Point POINT_OF_SHIELD = new Point(Scaling.EQUIPMENT_SHIELD_X, Scaling.EQUIPMENT_SHIELD_Y);
	private static final Point POINT_OF_BOOTS = new Point(Scaling.EQUIPMENT_BOOTS_X, Scaling.EQUIPMENT_BOOTS_Y);
	private static final Point SIZE_OF_SLOT = new Point(Scaling.EQUIPMENT_SLOT_WIDTH, Scaling.EQUIPMENT_SLOT_HEIGHT);
	private static final Point EQUIPMENT_SLOT_OFFSET = new Point(Scaling.EQUIPMENT_SLOT_OFFSET_WIDTH,Scaling.EQUIPMENT_SLOT_OFFSET_HEIGHT);
	
	private static final String EQUIPMENT_WEAPON_IMAGE_PATH = "src/res/img/Equipment_Weapon_Slot.png";
	private static final String EQUIPMENT_ARMOR_IMAGE_PATH = "src/res/img/Equipment_Armor_Slot.png";
	private static final String EQUIPMENT_BOOTS_IMAGE_PATH = "src/res/img/Equipment_Boots_Slot.png";
	private static final String EQUIPMENT_GLOVES_IMAGE_PATH = "src/res/img/Equipment_Gloves_Slot.png";
	private static final String EQUIPMENT_LEGGINGS_IMAGE_PATH = "src/res/img/Equipment_Leggings_Slot.png";
	private static final String EQUIPMENT_SHIELD_IMAGE_PATH = "src/res/img/Equipment_Shield_Slot.png";
	private static final String EQUIPMENT_HELMET_IMAGE_PATH = "src/res/img/Equipment_Helmet_Slot.png";
	
	
	/**************************  POINTS ON THE GRAPH,  SLOTS FOR ARRAYS   ***********************************/
	public static final Point ARMOR_POINT = new Point((Scaling.EQUIPMENT_ARMOR_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_ARMOR_Y/ Scaling.EQUIPMENT_SLOT_HEIGHT));
	public static final Point WEAPON_POINT = new Point ((Scaling.EQUIPMENT_WEAPON_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_WEAPON_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point HELMET_POINT = new Point ((Scaling.EQUIPMENT_HELMET_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_HELMET_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point GLOVES_POINT = new Point ((Scaling.EQUIPMENT_GLOVES_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_GLOVES_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point BOOTS_POINT = new Point ((Scaling.EQUIPMENT_BOOTS_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_BOOTS_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point SHIELD_POINT = new Point ((Scaling.EQUIPMENT_SHIELD_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_SHIELD_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	public static final Point LEGGINGS_POINT = new Point ((Scaling.EQUIPMENT_LEGGINGS_X/ Scaling.EQUIPMENT_SLOT_WIDTH)
			,(Scaling.EQUIPMENT_LEGGINGS_Y/ Scaling.EQUIPMENT_SLOT_WIDTH));
	
	private static final long serialVersionUID = 147952L;
	
	// DELETE THIS ONCE WE HAVE ALL THE SLOTS IN EQUIPMENT  boots, Shield,......
	private ArmorSlot uselessSlot = new ArmorSlot();
	
	private Equipment equipment;
	private static BufferedImage weaponImage;
	private static BufferedImage armorImage;
	private static BufferedImage bootsImage;
	private static BufferedImage shieldImage;
	private static BufferedImage glovesImage;
	private static BufferedImage leggingsImage;
	private static BufferedImage helmetImage;
	
	private static ItemImageVisitor itemVisitor = new ItemImageVisitor(EQUIPMENT_SLOT_OFFSET);
	
	
	// NOTE IT IS NOT SPECIFIC TO THE SLOT,  BUT ONLY TO EQUIPMENT
	//  			equipment.getArmorSlot().unequip();   will NOT work
	//   equipment.unequipArmor();  		WILL WORK
	public EquipmentView(Equipment equipment){
		this.equipment = equipment;
		equipment.addObserver(this);
		this.setEquipmentImages();
	}
	
	private BufferedImage getEquipmentSlotImage(BufferedImage equipment, BufferedImage itemImage){
		return ImageProcessing.overlayImages(equipment,itemImage);
	}
	
	private BufferedImage setImage(BufferSlot slot, String imagePath){
		BufferedImage image = ImageProcessing.scaleImage(SIZE_OF_SLOT, imagePath);
		if (slot.has()){
			slot.get().accept(itemVisitor);
			BufferedImage itemImage = itemVisitor.getImage();
			image= this.getEquipmentSlotImage(image,itemImage);
		}
		return image;
	}
	
	
	public void setEquipmentImages(){
		this.weaponImage = this.setImage(this.equipment.getSlot(Equipment.WEAPON_SLOT), EQUIPMENT_WEAPON_IMAGE_PATH);
		this.armorImage = this.setImage(this.equipment.getSlot(Equipment.ARMOR_SLOT), EQUIPMENT_ARMOR_IMAGE_PATH);
		this.bootsImage = this.setImage(this.uselessSlot, EQUIPMENT_BOOTS_IMAGE_PATH);
		this.glovesImage = this.setImage(this.uselessSlot, EQUIPMENT_GLOVES_IMAGE_PATH);
		this.shieldImage = this.setImage(this.uselessSlot, EQUIPMENT_SHIELD_IMAGE_PATH);
		this.leggingsImage = this.setImage(this.uselessSlot, EQUIPMENT_LEGGINGS_IMAGE_PATH);
		this.helmetImage = this.setImage(this.uselessSlot, EQUIPMENT_HELMET_IMAGE_PATH);
	}
	
	public void update() {
		this.setEquipmentImages();
	}
	
	public Equipment getEquipment(){
		return this.equipment;
	}

	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.drawImage(this.weaponImage, POINT_OF_WEAPON.getX(), POINT_OF_ARMOR.getY(), null);
		g.drawImage(this.armorImage, POINT_OF_ARMOR.getX(), POINT_OF_ARMOR.getY(),null);
		g.drawImage(this.bootsImage, POINT_OF_BOOTS.getX(), POINT_OF_BOOTS.getY(), null);
		g.drawImage(this.glovesImage, POINT_OF_GLOVES.getX(), POINT_OF_GLOVES.getY(), null);
		g.drawImage(this.shieldImage, POINT_OF_SHIELD.getX(), POINT_OF_SHIELD.getY(), null);
		g.drawImage(this.helmetImage, POINT_OF_HELMET.getX(), POINT_OF_HELMET.getY(), null);
		g.drawImage(this.leggingsImage, POINT_OF_LEGGINGS.getX(), POINT_OF_LEGGINGS.getY(), null);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(Scaling.EQUIPMENT_VIEW_WIDTH,Scaling.EQUIPMENT_VIEW_HEIGHT);
	}
}
