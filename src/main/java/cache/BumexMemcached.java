package cache;

public class BumexMemcached {

	private static final BumexMemcached INSTANCE = new BumexMemcached();

	private BumexMemcached() {
		if (INSTANCE != null) {
			throw new IllegalStateException("BumexMemcached Ya fue creada");
		}
	}
	
	public static BumexMemcached getInstance() {
		return INSTANCE;
	}

	public void set(String key, Object value) {

	}

	public Object get(String key) {
		return null;
	}

	public void delete(String key) {

	}

}
