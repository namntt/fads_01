package common;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UserCustomFile {
	final static String MY_PATH = "fads_01\\src\\main\\webapp\\assets\\images";

	public static void saveFileLocal(File my_file, String file_name) {

		try {
			ServletContext context = ServletActionContext.getServletContext();
			String absolute_path = context.getRealPath("");
			int index_1 = absolute_path.indexOf(".metadata");

			String final_path = absolute_path.substring(0, index_1);
			final_path = final_path + MY_PATH;

			File dir = new File(final_path);
			if (!dir.exists())
				dir.mkdirs();
			File fileToCreate = new File(final_path, file_name);
			FileUtils.copyFile(my_file, fileToCreate);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
