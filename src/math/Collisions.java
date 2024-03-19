package math;

import java.awt.geom.Point2D;

import math.Vector2D;

public interface Collisions {
	
	public static boolean CollisionRectCircle(Vector2D centerPos, float radius, Vector2D rectPos, float w, float h) {
		Vector2D rect = new Vector2D((rectPos.x + w / 2), (rectPos.y + h / 2));
		float circleDistanceX = Math.abs(centerPos.x - rect.x);
	    float circleDistanceY = Math.abs(centerPos.y - rect.y);

	    if (circleDistanceX > (w/2 + radius)) { return false; }
	    if (circleDistanceY > (h/2 + radius)) { return false; }

	    if (circleDistanceX <= (w/2)) { return true; } 
	    if (circleDistanceY <= (h/2)) { return true; }

	    float cornerDistance_sq = (circleDistanceX - w/2)*(circleDistanceX - w/2) +
	                         (circleDistanceY - h/2)*(circleDistanceY - h/2);

	    return (cornerDistance_sq <= (radius * radius));
	}
	
	public static boolean CollisionCirclePoint(Vector2D point, Vector2D center, float radius) {
		double distance = Point2D.distance(point.x, point.y, center.x, center.y);
		
		return distance < radius;
	}
	
	public static boolean CollisionCircleCircle(Vector2D center1, float radius1, Vector2D center2, float radius2) {
		double distance = Point2D.distance(center1.x, center1.y, center2.x, center2.y);
		
		return distance < Math.abs(radius1) + Math.abs(radius2);
	}
	
	
}
