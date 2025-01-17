package conversor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Conversor {
	private FileReader rw;
	private BufferedReader br;
	private BufferedWriter bw;
	private FileWriter fw ;

	public Conversor() throws IOException {
		rw = new FileReader("/Users/diego/eclipse-workspace/Conversor/src/Silicon.csv");
		br = new BufferedReader(rw);
		fw = new FileWriter("/Users/diego/Dropbox/Universidad/3º/Segundo Cuatrimestre/Mineria de Datos/Trabajo/silicon-valley-diversity-data/SiliconPost.csv");
		bw = new BufferedWriter(fw);

	}

	public void procesamiento() throws IOException {
		String str;
		int index = 0;
		int rep;
		String aux;
		bw.write("company,race,gender,job_category\n");
		for(int j = 0;j < 2940;j++) {
			str = br.readLine();
			for(int i = 1; i < 10;i++) {
				Character ch = str.charAt(str.length()-i);
				if(ch.equals(',')){
					index = str.length()-i;
					break;
				}
			}
			try {
				aux = str.substring(index+1, str.length());
				rep = Integer.parseInt(aux);
				str = str.substring(0, index);

				for(int i = 0; i<rep;i++) {
					bw.write(str+"\n");
					System.out.println(str);

				}
			}catch (StringIndexOutOfBoundsException e) {
				System.out.println(j);
			}
		}
		bw.close();
	}
}
