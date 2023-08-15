package mywindow;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {

	private int width, height;
	private String title;
	private Long glfwWindow;
	private static Window window = null;

	private Window(){
		this.width = 1920;
		this.height = 1080;
		this.title = "What Platformer";
	}

	public static Window get(){
		if (Window.window == null){
			Window.window = new Window();
		}
		return Window.window;
	}

	public void run(){
		System.out.println("Hello LWGJL " + Version.getVersion() + "!");

		init();
		loop();
	}

	public void init(){
		// error callback
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW
		if (!glfwInit()){
			throw new IllegalStateException("Unable to initialize GLFW");
		}

		// Configure GLFW
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
		glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

		// Create Window
		glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
		if(glfwWindow == NULL){
			throw new IllegalStateException("Failed to create the GLFW Window");
		}

		// Make the OpenGL context current
		glfwMakeContextCurrent(glfwWindow);

		// Enable V-Sync
		glfwSwapInterval(1);

		// Make the window visible
		glfwShowWindow(glfwWindow);
	}

	public void loop(){

	}
}
