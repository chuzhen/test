package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			ServerSocket server = new ServerSocket(2000);
			
			while(true) {
				Socket socket = server.accept();
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				
//				String line = br.readLine();
				pw.println("server");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
