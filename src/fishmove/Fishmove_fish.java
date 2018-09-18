package fishmove;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Fishmove_fish extends PApplet {
	public PImage img;
	public PVector pos;
	public PVector v;
	public PVector d;

	Fishmove_fish(PImage img, int x, int y, int vx, int vy, int dx, int dy) {
		this.img = img;
		this.img.resize(img.width / 2, img.height / 2);// 魚の画像サイズを半分にする
		this.pos = new PVector(x, y);
		this.v = new PVector(vx, vy);
		this.d = new PVector(dx, dy);
	}

	public void fish_draw() {// 描く
		// image(fish,0,0);
		// 色を取得し描く
		for (int y = 0; y < img.height; y += 2) {
			for (int x = 0; x < img.width; x += 2) {
				/*color c = img.get(x, y);
				float h = hue(c);
				float s = saturation(c);
				float b = brightness(c);
				if (s > 2) {
					// 彩度(Saturation)が低い＝白色が強い時は透明にする//必要ならば：&& b > 20
					stroke(h, s, b);
				} else {
					stroke(h, s, b, 0);
				}*/
				//strokeWeight(3);
				if (d.x == 1) {// 魚の進行方向によって画像の向きを左右反転
					if(height > pos.x + (img.height - x) && 0 < pos.x + (img.height - x) && width > pos.y + y && 0 < pos.y + y)point(pos.x + (img.height - x), pos.y + y);
					//System.out.println(height+":"+pos.x + (img.height - x)+"//"+width+":"+pos.y + y);
				} else {
					if(height > pos.x + x && 0 < pos.x + x && width > pos.y + y && 0 < pos.y + y)point(pos.x + x, pos.y + y);
					//System.out.println(height+":"+pos.x + x + (img.height - x)+"//"+width+":"+pos.y + y);
				}

			}
		}
	}

	public void fish_move() {// 動かす
		pos.x += v.x * d.x;// 距離＊方向
		pos.y += v.y * d.y;
	}

	public void fish_classfy() {// 当たっているか判定
		if (width + img.width <= pos.x || 0 - img.width >= pos.x)
			d.x *= -1;// img.width,img.heightは余裕を持たせるため
		if (height + img.height <= pos.y || 0 - img.height >= pos.y)
			d.y *= -1;
	}

}
