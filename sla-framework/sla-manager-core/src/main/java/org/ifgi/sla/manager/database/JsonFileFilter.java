package org.ifgi.sla.manager.database;

import java.io.File;
import java.io.FilenameFilter;

public class JsonFileFilter implements FilenameFilter
{
	/**
	 * @param f
	 * @param s
	 * @return
	 */
	public boolean accept(File f, String s)
	{
		return s.toLowerCase().endsWith(".json");
	}

}
