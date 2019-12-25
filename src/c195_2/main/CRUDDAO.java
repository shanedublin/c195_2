package c195_2.main;

public interface CRUDDAO {
	public <T extends Entity> T getByName(String name);
	public <T extends Entity> T getById(int id);
	public <T extends Entity> T add(T object);
	public <T extends Entity> T create(T object);
	public <T extends Entity> boolean delete(T object);
}
