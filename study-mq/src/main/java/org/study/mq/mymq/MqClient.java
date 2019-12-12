package org.study.mq.mymq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author wangmin
 * @description MQ客户端
 * created at 2019/12/12 4:42 下午
 */
public class MqClient {
	//生产消息
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

	//消费消息
	public static String consume() throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			//先向消息队列发送字符串"CONSUME"表示消费
			out.println("CONSUME");
			out.flush();
			//再从消息队列获取一条消息
			String message = in.readLine();
			return message;
		} catch (Exception e) {
			throw e;
		}
	}
}
