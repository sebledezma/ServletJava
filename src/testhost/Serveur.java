package testhost;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//source Open Classroom
public class Serveur {
	public static void main(String[] args) {
		try{
			ServerSocket serveur= new ServerSocket(5000);
			boolean fini=false;
			while(!fini) {
				Socket socket = serveur.accept();
				// attente active d�un client
				// r�cup�ration de la requ�te
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Object obj = ois.readObject();
				System.out.println("le serveur a re�u : " + obj);
				// envoi de la r�ponse
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				fini=(((int)(Math.random()*5))==0);
				oos.writeObject(new Boolean(fini));
				socket.close();
			}
			System.out.println("fermeture du serveur");
			serveur.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
