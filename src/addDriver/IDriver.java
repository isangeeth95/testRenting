package addDriver;

import javax.servlet.http.Part;

public interface IDriver {
	public String extractImageName(Part part);
}
