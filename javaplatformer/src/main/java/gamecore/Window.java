package gamecore;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
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

		// free the memory
		glfwFreeCallbacks(glfwWindow);
		glfwDestroyWindow(glfwWindow);

		// terminate GLFW and free the error callback
		glfwTerminate();
		Objects.requireNonNull(glfwSetErrorCallback(null)).free();
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

		// This line is critical for LWJGL's interoperation with GLFW's
		// OpenGL context, or any context that is managed externally.
		// LWJGL detects the context that is current in the current thread,
		// creates the GLCapabilities instance and makes the OpenGL
		// bindings available for use.
		GL.createCapabilities();
	}

	public void loop(){

		while ( !glfwWindowShouldClose(glfwWindow) ) {
			// Poll for window events. The key callback above will only be
			// invoked during this call.
			glfwPollEvents();

			// Set the clear color
			glClearColor(1.0f, 0.0f, 0.0f, 0.0f);

			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

			glfwSwapBuffers(glfwWindow); // swap the color buffers
		}

	}
}
