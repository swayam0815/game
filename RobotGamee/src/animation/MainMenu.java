package animation;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import hsa2.GraphicsConsole;

public class MainMenu {

	private static Dimension GRsize = Toolkit.getDefaultToolkit().getScreenSize(); // creates a variable to get screen
	// size
	private static int GRHEIGHT = (int) GRsize.getHeight() - 70; // (int)GRsize.getHeight() - 70
	private static int GRWIDTH = (int) (GRHEIGHT * 1.777777777778); // this sets the size of the grid to fit the screen

	private static GraphicsConsole gc = new GraphicsConsole(GRWIDTH, GRHEIGHT);

	private static Rectangle playButton = new Rectangle(GRWIDTH / 2, GRHEIGHT / 4, 500, 500);
	private static Color playColor = Color.RED;
	private static Rectangle CrossHair = new Rectangle(GRWIDTH / 2, GRHEIGHT / 2, GRHEIGHT / 10, GRHEIGHT / 10); // to
																													// aim
	private static Image crosshair;
	private static Image bkg;
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		gc.enableMouseMotion();
		gc.enableMouse(); // enables motion and click for the mouse
		new MainMenu();
	}

	public MainMenu() throws IOException {
		crosshair = ImageIO.read(new File("crosshair.png"));
		
		bkg = ImageIO.read(new File("ROBOT.png"));
		
		
		while (true) {
			mechanics();
			drawGraphics();
			gc.sleep(1);
		}
	}

	private void mechanics() {
		CrossHair.x = gc.getMouseX() - (CrossHair.width / 2);
		CrossHair.y = gc.getMouseY() - (CrossHair.height / 2);

	}

	private void drawGraphics() {
		synchronized (gc) {
			gc.clear();
			gc.drawImage(bkg, 0, 0, GRWIDTH, GRHEIGHT);
			gc.drawRect(new Rectangle(GRWIDTH / 2, GRHEIGHT / 4 + 100, 500, 109));
			gc.drawImage(crosshair, CrossHair.x, CrossHair.y, CrossHair.width, CrossHair.height);
		}
	}

}
