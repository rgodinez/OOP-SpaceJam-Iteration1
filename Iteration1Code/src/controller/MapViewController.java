package controller;

import model.Avatar;
import model.GameMap;
import model.Location;
import model.Tile;
import model.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


//public class MapViewController extends JFrame{
public class MapViewController{
	private static final long serialVersionUID = 1L;
	private GameMap map ;
	public Avatar avatar;
	//public BufferedImage image;
	//TODO	link with the MapView
	
	//Map View Controller should NOT have a JFrame
	public MapViewController(GameMap map, Avatar avatar,JFrame frame){ //added GameMap here
		frame.addKeyListener(new CharacterKeyboardController());
		this.avatar = avatar;
		this.map=map;
		//image=avatar.loadImage();
		
		
	}
	
	
	public class CharacterKeyboardController implements KeyListener{
		private final Point NORTH = new Point(0,1);
		private final Point SOUTH = new Point(0,-1);
		private final Point SOUTHWEST = new Point(-1,-1);
		private final Point NORTHWEST = new Point(-1,1);
		private final Point WEST = new Point(-1,0);
		private final Point NORTHEAST = new Point(1,1);
		private final Point SOUTHEAST = new Point(1,-1);
		private final Point EAST = new Point(1,0);
		
		
		public Location getAvatarLocation(){
			return map.getLocation(avatar);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			Location avatarLocation = this.getAvatarLocation();
			//System.out.println(e.getKeyCode()); used for debugging
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD1 || e.getKeyCode()==KeyEvent.VK_1){
				int x= map.getLocation(avatar).getX()-1;
				int y=map.getLocation(avatar).getY()+1;
				avatarLocation.add(SOUTHWEST);
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
				
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD2 || e.getKeyCode()==KeyEvent.VK_2){
				int x= map.getLocation(avatar).getX();
				int y=map.getLocation(avatar).getY()+1;
				avatarLocation.add(SOUTH);
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
				
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD3 || e.getKeyCode()==KeyEvent.VK_3){
				int x= map.getLocation(avatar).getX()+1;
				int y=map.getLocation(avatar).getY()+1;
				avatarLocation.add(SOUTHEAST);
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
				//map.setD(100); //not complete testing moving map under
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD6 || e.getKeyCode()==KeyEvent.VK_6){
				int x= map.getLocation(avatar).getX()+1;
				int y=map.getLocation(avatar).getY();
				avatarLocation.add(EAST);
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD9 || e.getKeyCode()==KeyEvent.VK_9){
				int x= map.getLocation(avatar).getX()+1;
				int y=map.getLocation(avatar).getY()-1;
				avatarLocation.add(NORTHEAST);
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD8 || e.getKeyCode()==KeyEvent.VK_8){
				int x= map.getLocation(avatar).getX();
				int y=map.getLocation(avatar).getY()-1;
				avatarLocation.add(NORTH);
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD7 || e.getKeyCode()==KeyEvent.VK_7){
				int x= map.getLocation(avatar).getX()-1;
				int y=map.getLocation(avatar).getY()-1;
				avatarLocation.add(NORTHWEST);
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD4 || e.getKeyCode()==KeyEvent.VK_4){
				int x= map.getLocation(avatar).getX()-1;
				int y=map.getLocation(avatar).getY();
				avatarLocation.add(WEST);
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			//map.setD(0);  //not done
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	/*public static void main(String[]args){
		Avatar avatar = new Avatar();
		MapViewController mv = new MapViewController(avatar);
		mv.setVisible(true);
		
		
	}*/
	
 
}
