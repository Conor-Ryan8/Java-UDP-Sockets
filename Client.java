package sockets;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	
	public static void main(String[] args) throws Exception
	{
		
		DatagramSocket sock = new DatagramSocket();

		//Create something to be sent to the socket
		String data = "Test Message 1";
		
		//Convert the "data" to a byte array to be sent to the socket
		byte[] bytes = data.getBytes();

		//Set/find IP address of the server
		InetAddress address = InetAddress.getLocalHost();
		
		//Create new packet "datapacket" for sending data to the socket and pass it connection information and byte array to be sent
		DatagramPacket datapacket = new DatagramPacket(bytes,bytes.length,address,9999);
		
		//Send the packet to the socket
		sock.send(datapacket);
		
		//Close the socket
		sock.close();

	}

}