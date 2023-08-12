package mywindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WindowTest {

	private Window windowMock;

	@Test
	public void testGetWindow(){
		Window resultWindow = Window.get();

		Assertions.assertEquals(resultWindow.getClass(), Window.class);
	}

}
