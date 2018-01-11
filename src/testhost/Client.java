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
			// ouverture d'une connexion TCP
			Socket socket= new Socket(InetAddress.getLocalHost(), 5000);
			ObjectOutputStream oos = new ObjectOutputStream( socket.getOutputStream());
			// envoi vers le serveur de cette �requ�te�
			SortedSet<String> l = new TreeSet<String>();
			l.add("TCP");
			l.add("essai");
			oos.writeObject( l);
			// lecture de la r�ponse retourn�e
			ObjectInputStream ois =	new ObjectInputStream( socket.getInputStream());
			System.out.println("le serveur retourne : " + ois.readObject());
			socket.close(); 
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
