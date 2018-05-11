/*********************************************
 * Conor Ryan - Socket Programming - Java    *
 * Basic UDP Client                          *
 * April 2018                                *
 *********************************************/

package testtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket socket = new DatagramSocket();
		String temp = null;
		byte[] data = null;
		int port = 0;
		InetAddress address = null;
		
	    System.out.print("Please enter IP Address: ");
	  	try 
	    {
	    	temp = reader.readLine();
			address = InetAddress.getByName(temp);
		} 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
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
		System.out.print("Please enter message: ");
	  	try 
	    {
	    	temp = reader.readLine();
	    	data = temp.getBytes();
		} 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
		
		//Create new packet "datapacket" for sending data to the socket and pass it connection information and byte array to be sent
		DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
		
		//Send the packet to the socket
		socket.send(packet);
		
		//Close the socket
		socket.close();
	}
}
