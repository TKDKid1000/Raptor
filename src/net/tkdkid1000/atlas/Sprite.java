package net.tkdkid1000.atlas;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Sprite {

	protected Image image;
	protected ImageView imageView;

	protected Pane layer;

	protected double x;
	protected double y;
	protected double r;

	protected double dx;
	protected double dy;
	protected double dr;

	protected double health;
	protected double damage;

	protected boolean removable = false;

	protected double width;
	protected double height;

	protected boolean canMove = true;

	public Sprite(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr, double health, double damage) {

		this.layer = layer;
		this.image = image;
		this.x = x;
		this.y = y;
		this.r = r;
		this.dx = dx;
		this.dy = dy;
		this.dr = dr;

		this.health = health;
		this.damage = damage;

		this.imageView = new ImageView(image);
		this.imageView.relocate(x, y);
		this.imageView.setRotate(r);

		this.width = image.getWidth();
		this.height = image.getHeight();

		addToLayer();
	}

	public void addToLayer() {
		this.layer.getChildren().add(this.imageView);
	}

	public void removeFromLayer() {
		this.layer.getChildren().remove(this.imageView);
	}

	public Pane getLayer() {
		return layer;
	}

	public void setLayer(Pane layer) {
		this.layer = layer;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getDr() {
		return dr;
	}

	public void setDr(double dr) {
		this.dr = dr;
	}

	public double getHealth() {
		return health;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public boolean isRemovable() {
		return removable;
	}

	public void setRemovable(boolean removable) {
		this.removable = removable;
	}
	
	public Bounds getBounds() {
		return imageView.getBoundsInParent();
	}
	
	public void move() {

		if(!canMove)
			return;

		x += dx;
		y += dy;
		r += dr;

	}
	
	public void translate(double x, double y, double r) {
		dx=x;
		dy=y;
		dr=r;
	}

	public boolean isAlive() {
		return Double.compare(health, 0) > 0;
	}

	public ImageView getView() {
		return imageView;
	}

	public void updateUI() {

		imageView.relocate(x, y);
		imageView.setRotate(r);

	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getCenterX() {
		return x + width * 0.5;
	}

	public double getCenterY() {
		return y + height * 0.5;
	}

	public boolean collidesWith(Node other) {

		return (other.getBoundsInParent().getMaxX() >= getBounds().getMinX()
				&& other.getBoundsInParent().getMaxY() >= getBounds().getMinY() 
				&& other.getBoundsInParent().getMinX() <= getBounds().getMaxX() 
				&& other.getBoundsInParent().getMinY() <= getBounds().getMaxY());

	}
	
	public boolean collidesWith(Sprite other) {

		return (other.getBounds().getMaxX() >= getBounds().getMinX()
				&& other.getBounds().getMaxY() >= getBounds().getMinY() 
				&& other.getBounds().getMinX() <= getBounds().getMaxX() 
				&& other.getBounds().getMinY() <= getBounds().getMaxY());

	}

	public void getDamagedBy(Sprite sprite) {
		health -= sprite.getDamage();
	}

	public void kill() {
		setHealth(0);
	}

	public void remove() {
		setRemovable(true);
	}

	public void setMovement(boolean canMove) {
		this.canMove = canMove;
	}

	public abstract void checkRemovability();
}
