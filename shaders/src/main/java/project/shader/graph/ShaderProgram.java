package project.shader.graph;
import static org.lwjgl.opengl.GL20.*;

public class ShaderProgram {
	private final int programId;
	private int vertexShaderId;
	private int fragmentShaderId;
	
	public ShaderProgram() throws Exception {
		programId = glCreateProgram();
		if (programId == 0)
				throw new Exception("Could not create shader");
	}
	
	public void createVertexShader(String shaderCode) throws Exception{
		vertexShaderId = createShader(shaderCode,GL_VERTEX_SHADER);
	}
	
	
	public void createFragmentShader(String shaderCode) throws Exception{
		vertexShaderId = createShader(shaderCode,GL_FRAGMENT_SHADER);
	}

	private int createShader(String shaderCode, int shaderType)throws Exception {
		int shaderId = glCreateShader(shaderType);
		if (shaderId == 0)
			throw new Exception("Error creating shader. Type - " + shaderType);
		
		glShaderSource(shaderId, shaderCode);
		glCompileShader(shaderId);
		
		if (glGetShaderi(shaderId, GL_COMPILE_STATUS) == 0)
			throw new Exception("Error compile shader code" + glGetShaderInfoLog(shaderId, 1024));
		
		glAttachShader(programId, shaderId);
		return shaderId;
	}
	
	public void link() throws Exception{
		glLinkProgram(programId);
		
		if (glGetProgrami(programId, GL_LINK_STATUS) == 0)
			throw new Exception("Error Linked shader code " + glGetProgramInfoLog(programId, 1024));
		
		if (vertexShaderId != 0)
			glDetachShader(programId, vertexShaderId);
		if (fragmentShaderId != 0)
			glDetachShader(programId, fragmentShaderId);
		
	}
	public void bind() {
		glUseProgram(programId);
	}
	public void unbind() {
		glUseProgram(0);
	}
	public void cleanup() {
		unbind();
		if (programId !=0)
			glDeleteProgram(programId);
	}

}
