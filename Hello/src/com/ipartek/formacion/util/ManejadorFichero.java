package com.ipartek.formacion.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public final class ManejadorFichero {

	private ManejadorFichero() {

	}

	public List<String> leerFichero() {
		List<String> texto = null;
		// c:\archivo.txt
		final String ruta = System.getProperty("user.dir")
				+ System.getProperty("file.separator") + "file"
				+ System.getProperty("file.separator") + "archivo.txt";
		File archivo = new File(ruta);
		String palabra = "";
		try {
			FileInputStream fin = new FileInputStream(archivo);
			BufferedInputStream in = new BufferedInputStream(fin);
			// caracter a caracter
			final FileReader fr = new FileReader(archivo);
			int c;

			while ((c = fr.read()) != -1) {
				palabra += c;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		texto.add(palabra);
		return texto;
	}
}
