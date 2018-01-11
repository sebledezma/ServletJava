package testhost;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.SortedSet;
import java.util.TreeSet;

public class Client {
	//source Open Classroom
	public static void main(String[] args) {
		try {
			boolean fini=false;
			while(!fini) {
			// ouverture d'une connexion TCP
			Socket socket= new Socket(InetAddress.getLocalHost(), 5000);
				ObjectOutputStream oos = new ObjectOutputStream( socket.getOutputStream());
				// envoi vers le serveur de cette «requête»
				SortedSet<String> l = new TreeSet<String>();
				l.add("TCP");
				l.add("essai");
				oos.writeObject(l);
				// lecture de la réponse retournée
				ObjectInputStream ois =	new ObjectInputStream( socket.getInputStream());
				fini =((Boolean)ois.readObject());
				System.out.println("le serveur retourne : " + fini);
				socket.close();
				
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
