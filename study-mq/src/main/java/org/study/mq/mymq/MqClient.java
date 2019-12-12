package org.study.mq.mymq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author wangmin
 * @description MQ�ͻ���
 * created at 2019/12/12 4:42 ����
 */
public class MqClient {
	//������Ϣ
	public static void produce(String message) throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println(message);
			out.flush();
		} catch (Exception e) {
			throw e;
		}
	}

	//������Ϣ
	public static String consume() throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			//������Ϣ���з����ַ���"CONSUME"��ʾ����
			out.println("CONSUME");
			out.flush();
			//�ٴ���Ϣ���л�ȡһ����Ϣ
			String message = in.readLine();
			return message;
		} catch (Exception e) {
			throw e;
		}
	}
}
