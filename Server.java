/*******************************************************************************
 * Conor Ryan - Socket Programming - Java				       *
 * Basic UDP Server							       *
 * April 2018			       				               *
 *******************************************************************************/

package sockets;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server 
{
	public static void main(String[] args) throws Exception
	{
			//Create new datagram server socket "servsock" and pass it port number
			DatagramSocket servsock = new DatagramSocket(9999);
			
			//Create blank array for incoming data
			byte[] blankbyte = new byte[1024];
			
			//Create a new packet "incomingpacket" for incoming data
			DatagramPacket incomingpacket = new DatagramPacket(blankbyte,blankbyte.length);
			
			//Recieve "incomingpacket" from the socket
			servsock.receive(incomingpacket);
			
			//Convert the byte array "bytes" into a string
			String data = new String(incomingpacket.getData());
			
			//Display the data receieved to the user
			System.out.println("Client Sent: " + data);
			
			//Close the server socket "servsock"
			servsock.close();

	}
}
