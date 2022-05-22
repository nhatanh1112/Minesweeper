package tools;

import java.util.TreeSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Leaderboard.Leader;

public class StaticTool {

	public static int allcount = 10;
	public static int allcol = 9;
	public static int allrow = 9;
	public static int timecount = 0;
	public static int bombCount = allcount;

	public static boolean isStart = false;
	public static boolean isHole = false;

	public static Icon[] num = new Icon[10];
	public static Icon[] time = new Icon[11];

	// all images from resources
	public static ImageIcon imageIcon = new ImageIcon("resources/icon.gif");
	public static Icon iconBlank = new ImageIcon("resources/blank.gif");
	public static Icon bloodIcon = new ImageIcon("resources/blood.gif");
	public static Icon icon0 = new ImageIcon("resources/0.gif");
	public static Icon clickIcon = new ImageIcon("resources/face2.gif");
	public static Icon smileIcon = new ImageIcon("resources/face0.gif");
	public static Icon faultFaceIcon = new ImageIcon("resources/face3.gif");
	public static Icon winFaceIcon = new ImageIcon("resources/face4.gif");
	public static Icon flagIcon = new ImageIcon("resources/flag.gif");
	public static Icon askIcon = new ImageIcon("resources/ask.gif");
	public static Icon askPressIcon = new ImageIcon("resources/ask1.gif");
	public static Icon downSmileIcon = new ImageIcon("resources/face1.gif");
	public static Icon errorBombIcon = new ImageIcon("resources/error.gif");
	public static Icon blackBombIcon = new ImageIcon("resources/mine.gif");
	public static Icon holeIcon = new ImageIcon("resources/hole.gif");

	static {

		for (int i = 0; i < num.length; i++) {
			num[i] = new ImageIcon("resources/" + i + ".gif");
		}
		for (int j = 0; j <= num.length; j++) {
			time[j] = new ImageIcon("resources/d" + j + ".gif");
		}

	}

	// Leaderboard
	public static TreeSet<Leader> treeSetC = new TreeSet<Leader>();
	public static TreeSet<Leader> treeSetZ = new TreeSet<Leader>();
	public static TreeSet<Leader> treeSetG = new TreeSet<Leader>();
	static {

		treeSetC.add(new Leader(999, "Name"));
		treeSetZ.add(new Leader(999, "Name"));
		treeSetG.add(new Leader(999, "Name"));

	}

	// Level
	public static int getLevel() {
		if (allrow == 9 && allcol == 9 && allcount == 10) {
			return 1;
		} else if (allrow == 16 && allcol == 16 && allcount == 40) {
			return 2;
		} else if (allrow == 16 && allcol == 30 && allcount == 99) {
			return 3;
		} else {
			return 0;
		}
	}

}
