package childage.forniture;

public class TemporaryForniture extends Forniture{

	private String path = "";
	
	public TemporaryForniture(int x, int y, FornitureListener listener,
			String path) {
		super(x, y, listener, path);
		
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
}
