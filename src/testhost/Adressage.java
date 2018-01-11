package testhost;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Adressage {
	public static void main(String[] args) {
		InetAddress LocaleAdresse ;
		InetAddress ServeurAdresse;
		try {
			LocaleAdresse = InetAddress.getLocalHost();
			System.out.println("locale = " + LocaleAdresse); 
			//source de l'exemple
			ServeurAdresse =
					InetAddress.getByName(
							"www.openclassrooms.com"
							);
			System.out.println("oc = "+ServeurAdresse);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}