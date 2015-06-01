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
			ServerSocket ss = new ServerSocket(5555) ;// ��Ʈ��ũ ��û��ȣ�� ��޸���.
			System.out.println("---���� �����غ����");
			socket = ss.accept();//-���� �� ���� ����
			save.add(socket);
			this.start();
			System.out.println("����2");
			

		} catch (Exception ex) {
			System.out.println("���½���");
			System.out.println(ex.getMessage());
		}
	}/// server end
	
	public void run(){
		System.out.println("run �޼ҵ� ����");
		String Ip = null;
		Ip = socket.getInetAddress().getHostAddress();
		System.out.println(Ip);// IP�ּ� ���
		try{
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			// InputStream�� ��Ʈ��ũ��(socket)���� ������ input(stream)�� represent ���ְ� 
			// InputStreamReader�� from byte Streams to characterStreams�� bridge��Ȱ�� �Ѵ�.
			// BufferedReader ������(input) ���� �������� �д� ��Ȱ�� �ϰ� 
			// BufferedReader�� �޼ҵ�readLine���� line of text�� ȿ�������� �����Ѵ�.
			
			System.out.println("47");
			while((msg = br.readLine()) != null){
				store.add(msg);
				System.out.println("49");
				
			for (String a : store){
				System.out.println("51");
				
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				System.out.println(store);
				System.out.println("���Ϲ� �ȿ� �־�");
		
				
			}
			}
		} catch(Exception ex){
			System.out.println("�б� ����");
			System.out.println(ex.getMessage());
		}
	}

}/// class end
