package net.hb.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread {
	String msg = null;
	Socket socket = new Socket();
	private Vector<Socket> save = new Vector<Socket>();
	private Vector<String> store = new Vector<String>();
	
	public static void main(String[] args) {
		

		Server server = new Server();
	}// main end

	public Server() {
		
		try {
			ServerSocket ss = new ServerSocket(5555) ;// 네트워크 요청신호를 기달린다.
			System.out.println("---서버 접속준비상태");
			socket = ss.accept();//-접속 후 이하 실행
			save.add(socket);
			this.start();
			System.out.println("오픈2");
			

		} catch (Exception ex) {
			System.out.println("오픈실패");
			System.out.println(ex.getMessage());
		}
	}/// server end
	
	public void run(){
		System.out.println("run 메소드 실행");
		String Ip = null;
		Ip = socket.getInetAddress().getHostAddress();
		System.out.println(Ip);// IP주소 출력
		try{
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			// InputStream은 네트워크를(socket)통해 들어오는 input(stream)을 represent 해주고 
			// InputStreamReader가 from byte Streams to characterStreams의 bridge역활을 한다.
			// BufferedReader 들어오는(input) 값을 실제적으 읽는 역활을 하고 
			// BufferedReader의 메소드readLine으로 line of text로 효율적으로 실행한다.
			
			System.out.println("47");
			while((msg = br.readLine()) != null){
				store.add(msg);
				System.out.println("49");
				
			for (String a : store){
				System.out.println("51");
				
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				System.out.println(store);
				System.out.println("와일문 안에 있어");
		
				
			}
			}
		} catch(Exception ex){
			System.out.println("읽기 실패");
			System.out.println(ex.getMessage());
		}
	}

}/// class end
