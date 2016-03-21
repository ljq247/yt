package object_to_generic.base;

public interface Dao<T> {
	void save(T t);
	T load();
}
