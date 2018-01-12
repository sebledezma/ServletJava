package testhost;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServeurDatagram {
	private static int ServerPort = 333; // Server identification
	private static int ClientPort = 334; // Client identification
	private static int MsgSize = 5;
	private static void simple() {
		try {
			DatagramSocket ds = new DatagramSocket(1234);
			boolean fini=false;
			while(!fini)
			{
				DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
				ds.receive(packet);
				System.out.println("Message: " + packet.getData());
			}
			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		simple();
	}
} 