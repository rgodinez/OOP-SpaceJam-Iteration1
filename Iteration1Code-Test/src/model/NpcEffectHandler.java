package model;

import java.util.Random;

import model.Entity.Avatar;
import model.Entity.Entity;
import model.Entity.Merchant;
import model.Entity.Orc;
import model.Entity.Skeleton;
import model.items.TakeableItem;
import model.items.Weapon;
import model.items.Weapons;


public class NpcEffectHandler {
	private Avatar avatar;
	
	public NpcEffectHandler(Avatar avatar){
		
		this.avatar=avatar;
		
	}
	
	public void apply(Entity npc,Location avatarLocation){
		
		
		
		// Let us now begin the Satan Ceremony
		if(npc!=null && npc instanceof Orc){
			//if(Integer.parseInt(avatar.getStat("Level"))>1){
			
			npc.getAreaEffect().apply(avatar); 
					int x,y;
					x=avatarLocation.getX();
					y=avatarLocation.getY();
					//System.out.println(x + " " + y);
					if(x==13 && y ==12)
					{
						npc.setState(1);
					}
					else if(x==14 && y==11)
					{
						npc.setState(2);
					}
					else if(x==14 && y==13)
					{
						npc.setState(3);
					}
					//npc.action(avatar);
					//tile.setItem(it);
				}
		
		else if(npc!=null && npc instanceof Skeleton){
			//if(Integer.parseInt(avatar.getStat("Level"))>1){
			
			
					int x,y;
					x=avatarLocation.getX();
					y=avatarLocation.getY();
					//System.out.println(x + " " + y);
					if(x==8 && y ==12)
					{
						npc.setState(1);
					}
					else if(x==9 && y==11)
					{
						npc.setState(2);
					}
					else if(x==9 && y==13)
					{
						npc.setState(3);
					}
					else if(x==10 && y==12)
					{
						npc.setState(4);
					}
					//npc.action(avatar);
					//tile.setItem(it);
					int randomness=randNo();
					if(randomness<5){
						System.out.println("You Can not Steal");
						if(avatar.getOccupation().getName()=="Hunter" ){
							System.out.println("Steal Success");
							Weapon weapon;
							if(randomness<=2){
								weapon= Weapons.LONGBOW.weapon;
							}
							else if(randomness==3)
							{
								weapon= Weapons.DRAGONBOW.weapon;
							}
							else{
								weapon= Weapons.PRESTINEBOW.weapon;
							}
							//TakeableItem droppedItem = (TakeableItem) map.getTile(tileLocation).getItem();
							TakeableItem droppedItem = (TakeableItem) weapon;
							avatar.getInventory().findAndEquip(droppedItem);
						}
						
						
					}
					if(randomness>=5){
						
						npc.getAreaEffect().apply(avatar); 
						System.out.println("Steal Failure");
					}
					
				}
		
		else if(npc!=null && npc instanceof Merchant){
			
			
					//MerchantView mv=new MerchantView();
					//mv.setVisible(true);
					//npc.action(avatar);
				}
			}
	
	public int randNo()
	{
		int x;
		Random rand=new Random();
		x=rand.nextInt()%10;
		return x;
	}
	
	}
	
	

