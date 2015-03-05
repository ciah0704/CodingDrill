/**
 * Calculate angle between clock's arrows
 * @author vkroz
 *
 */
public class Angle {
	public static int angle(int hour, int minute) {
		return Math.abs((hour*30-minute*6));
	}
}
