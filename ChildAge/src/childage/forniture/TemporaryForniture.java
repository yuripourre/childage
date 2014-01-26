package childage.forniture;

public class TemporaryForniture extends Forniture{

	private String path = "";
	
	private long dropped = 0;
	
	public TemporaryForniture(int x, int y, FornitureListener listener,
			String path) {
		super(x, y, listener, path);
		
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public long getDropped() {
		return dropped;
	}

	public void setDropped(long dropped) {
		this.dropped = dropped;
	}
	
}
