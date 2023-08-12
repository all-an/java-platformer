package main;

import org.junit.jupiter.api.Test;
import org.main.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainTest {

	@Test
	public void testMain() throws IOException {
		System.out.println("main");
		String[] args = null;
		final InputStream original = System.in;
		final FileInputStream fips = new FileInputStream(new File("C:\\Users\\Public\\code\\java-platformer\\javaplatformer\\src\\main\\java\\org\\main\\Main.java"));
		System.setIn(fips);
		Main.main(args);
		System.setIn(original);
	}
}
