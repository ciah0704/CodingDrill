package prog_exercises.exercises.misc;

import org.junit.Test;

public class AngleTest {

	@Test
	public void testAngle() {
		assertEquals(0, Angle.angle(0, 0));
		assertEquals(90, Angle.angle(3, 30));
		assertEquals(0, Angle.angle(6, 30));
		assertEquals(240, Angle.angle(1, 45));
		assertEquals(0, Angle.angle(9, 45));
		assertEquals(180, Angle.angle(3, 45));
	}

}
