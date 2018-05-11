/*********************************************
 * Conor Ryan - Socket Programming - Java    *
 * Basic UDP Server                          *
 * April 2018                                *
 *********************************************/

package testtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		int port = 0;
		
		System.out.print("Please enter port: ");
    	try 
    	{
        	temp = reader.readLine();
        	port = Integer.parseInt(temp);
    	} 
    	catch (IOException e) 
    	{
    		e.printStackTrace();
    	}
		
		//Create new datagram server socket "servsock" and pass it port number
    	DatagramSocket socket = new DatagramSocket(port);
			
    	//Create blank array for incoming data
    	byte[] blank = new byte[1024];
			
		//Create a new packet "incomingpacket" for incoming data
		DatagramPacket packet = new DatagramPacket(blank,blank.length);
		
		//Recieve "incomingpacket" from the socket
		socket.receive(packet);
		
		//Convert the byte array "bytes" into a string
		String data = new String(packet.getData());
		
		//Display the data receieved to the user
		System.out.println("Message received: " + data);
		
		//Close the server socket "servsock"
		socket.close();

	}
}
