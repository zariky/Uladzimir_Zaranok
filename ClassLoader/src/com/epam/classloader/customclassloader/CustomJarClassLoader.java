package com.epam.classloader.customclassloader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CustomJarClassLoader extends ClassLoader {

	private List<String> jarFiles;
	private Hashtable<String, Class<?>> classes = new Hashtable<String, Class<?>>();
	
	public CustomJarClassLoader(List<String> jarFiles) { 
		super(CustomJarClassLoader.class.getClassLoader()); 
		this.jarFiles = jarFiles;
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> resultClass = null;
		resultClass = (Class<?>) classes.get(name);
		if (resultClass != null) {
			return resultClass;
		}
		resultClass = getClassFromJar(name);
		if (resultClass != null) {
			classes.put(name, resultClass);
		} else {
			throw new ClassNotFoundException("Not found " + name);
		}
		return resultClass;
	}
	
	private Class<?> getClassFromJar(String className) {
		Class<?> result = null;
		for (String jarFile : jarFiles) {
			try (JarFile jar = new JarFile(jarFile)) {
				JarEntry entry = jar.getJarEntry(className.replace(".", "/") + ".class");
				InputStream is = jar.getInputStream(entry);
				ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
				int nextValue = is.read();

				while (-1 != nextValue) {
					byteStream.write(nextValue);
					nextValue = is.read();
				}

				byte classByte[] = byteStream.toByteArray();
				result = defineClass(className, classByte, 0, classByte.length,	null);
				return result;
			} catch (Exception e) {
				continue;
			}
		}
		return result;
	}
}
