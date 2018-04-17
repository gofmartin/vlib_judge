package vlib.util;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Utils {
	
	public static List<Class> classLoader(String filePath) 
			throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		File classPath = new File(filePath);
		ArrayList<Class> classList = new ArrayList<Class>();
		
		int classCount = 0;
		
		if(classPath.exists() && classPath.isDirectory()) {
			int classPathLen = classPath.getAbsolutePath().length() + 1;
			
			Stack<File> stack = new Stack<>();
			stack.push(classPath);
			
			while(stack.isEmpty() == false) {
				File path = stack.pop();
				File[] classFiles = path.listFiles(new FileFilter() {
					@Override
					public boolean accept(File pathname) {
						return pathname.isDirectory() || pathname.getName().endsWith(".class");
					}
				});
				for(File subFile : classFiles) {
					if(subFile.isDirectory()) {
						stack.push(subFile);
					} else {
						if(classCount++ ==0) {
							Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
							boolean accessible = method.isAccessible();
							try {
								if(accessible == false) {
									method.setAccessible(true);
								}
								URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
								
								method.invoke(classLoader, classPath.toURI().toURL());
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								method.setAccessible(accessible);
							}
						}
						
						String className = subFile.getAbsolutePath();
						className = className.substring(classPathLen, className.length() - 6);
						className = className.replace(File.separatorChar, '.');
						
						Class tClass = Class.forName(className);
						classList.add(tClass);
						System.out.println("读取应用程序类文件[class="+className+"]");
					}
				}
			}
		}
		
		return classList;
	}
	
}
