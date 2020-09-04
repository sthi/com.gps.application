package com.city.map;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReadCitiesFromFile {
	private static final Log log = LogFactory.getLog(CityMapperConfiguration.class);

	public static boolean readCitesFormFile(CityServiceImpl cityServiceImpl, File file) {

		boolean ok = true;
		Scanner scanner = null;

		try {
			scanner = new Scanner(file);
			int n = 0, okCount = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				n++;

				String pairs[] = line.split(",");
				if (pairs.length != 2) {
					ok = false;
					log.error("line " + n + ": format invalid -" + line);
					continue;
				}
				String node1 = pairs[0].trim();
				if (node1.length() == 0) {
					ok = false;
					log.error("line " + n + ": format invalid, the first string is empty - " + line);
					continue;
				}

				String node2 = pairs[1].trim();
				if (node2.length() == 0) {
					ok = false;
					log.error("line " + n + ": format invalid, the second string is empty - " + line);
					continue;
				}

				if (cityServiceImpl.addPath(node1, node2)) {
					okCount++;
				} else {
					ok = false;
				}
			}

			log.trace("read OK lines = " + okCount + "; read Error lines = " + (n - okCount));

			if (okCount == 0) {
				ok = false;
				log.error("failed to read any data from " + file.getAbsolutePath());
			}
		} catch (IOException e) {

			ok = false;
			log.error(e.getMessage() + " filepath = " + file.getAbsolutePath());
			// e.printStackTrace();

		}

		if (scanner != null) {
			scanner.close();
		}

		return ok;
	}

}
