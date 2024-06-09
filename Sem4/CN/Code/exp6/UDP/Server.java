import java.io.*;
import java.net.*;

class Server {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			System.out.println("RECEIVED: " + sentence);
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String sentSentence = inFromServer.readLine();
			// String capitalizedSentence = sentence.toUpperCase();
			sendData = sentSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
			receiveData = new byte[1024];
			if (sentSentence.equalsIgnoreCase("bye")) {
				serverSocket.close();
				break;
			}
		}
	}
}