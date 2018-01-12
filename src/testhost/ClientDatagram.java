package testhost;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientDatagram {
	private static int ServerPort = 333; // Server identification
	private static int ClientPort = 334; // Client identification
	private static String ServerName = null;
	private static int NbStep = 10; // Features of msg to send
	private static int MsgSize = 5;
	private static void simple() {
		try {
			byte[] data = "un message de bonjour".getBytes();
			InetAddress addr;
			addr = InetAddress.getByName("localhost");
			DatagramPacket packet = new DatagramPacket (data, data.length, addr,1234);
			DatagramSocket ds = new DatagramSocket();
			ds.send(packet);
			ds.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static byte[] getBytes(Object obj) throws java.io.IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		bos.close();
		byte [] data = bos.toByteArray();
		return data;
	}
	public static void main(String[] args) {
		simple();
		}
} 
