/*
 * RA: 2779730
 * Nome: Gabriel Mohamad
*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura{

	public String entDados(String rotulo){
		System.out.println(rotulo);
		
		InputStreamReader tec;
		tec = new InputStreamReader(System.in); 
		BufferedReader buff;
		buff = new BufferedReader(tec);
		
		String ret = "";
		
		try{
			ret = buff.readLine();
		}
		catch(IOException ioe){
			System.out.println("ERRO: JVM - RAM");
		}
		return ret;
	}

}
