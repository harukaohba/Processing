package fishmove;

import processing.core.PApplet;//追加
import processing.core.PImage;

public class Fishmove_main extends PApplet {// 継承する
	PImage img;
	Fishmove_fish[] fishs;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 動かすための関数
		String[] a = { "MA" };
		PApplet.runSketch(a, new Fishmove_main());

	}

	public void settings() {// 画面サイズ
		size(1100, 825);// 画面サイズ決定
	}

	public void setup() {
		colorMode(HSB, 360, 100, 100);// 色相(Hue)、彩度(Saturation)、明度(BrightnessもしくはValue)
		smooth();
		// frameRate(10);//フレームレート設定可能

		img = loadImage("data/fishmove/suisou.jpg");// boad.jpg
		// size(2200/2, 1650/2);//半分の大きさの画像に変更
		size(1100, 825);// 画面サイズ決定
		img.resize(width, height);// 背景画像は画面サイズと合わせる

		// 6匹動く
		fishs = new Fishmove_fish[6];
		for (int i = 0; i < 6; i++) {
			fishs[i] = new Fishmove_fish(loadImage("data/fishmove/fish" + i + ".jpg"),
					(int) random(width - (loadImage("data/fishmove/fish" + i + ".jpg").width + 10)), (int) random(height),
					(int) random(5) + 5, (int) random(3) + 2, rand01(), rand01());
		}

		// テスト用1匹(動かない)
		/*
		 * fish = loadImage("fish_test.jpg"); fish.resize(fish.width/2, fish.height/2);
		 */

	}

	private int rand01() {
		// TODO Auto-generated method stub
		// -1か1を返す
		if ((int) random(10) % 2 == 0) {
			return 1;
		} else {
			return -1;
		}
	}

	public void draw() {
		image(img, 0, 0);// 背景を描く

		// 6匹動く
		for (int i = 0; i < 6; i++) {
			fishs[i].fish_classfy();// ぶつかっているか判定
			fishs[i].fish_move();// 動かす
			fishs[i].fish_draw();// 描く
		}

	}

}
