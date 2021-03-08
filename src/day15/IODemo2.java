package day15;

import java.io.File;
import java.io.FilenameFilter;

public class IODemo2 {
	public static void main(String[] args) {
		File file = new File("C:/temp");
		System.out.println("Path: " + file.getAbsolutePath());
		System.out.println("File Name: " + file.getName());
		System.out.println("File Exists: " + (file.exists() ? "Yes" : "No"));
		System.out.println("Can Write: " + file.canWrite());
		System.out.println("Is Directory: " + file.isDirectory());
		
		File destFile = new File("C:/temp2");
		file.renameTo(destFile);
		String str[] = destFile.list(new MyFilter("html"));
		for(String s : str) {
			System.out.println(s);
		}
	}
}

class MyFilter implements FilenameFilter {
	String extension;
	public MyFilter(String extension) {
		this.extension = extension;
	}
	@Override
	public boolean accept(File dir, String name) {
		System.out.println(dir);
		return name.endsWith("." + extension);
	}
}