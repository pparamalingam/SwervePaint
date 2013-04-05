package application;

public interface SwerveFile {
	void open();
	void save(String filename, String location);
	void close();
}
