package org.study.mq.mymq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangmin
 * @description 消息中心服务
 * created at 2019/12/12 4:40 下午
 */
public class BrokerServer implements Runnable {
	public static int SERVICE_PORT = 9999;

	private final Socket socket;

	public BrokerServer(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while (true) {
				String str = in.readLine();
				if (str == null) {
					continue;
				}
				System.out.println("接收到原始数据：" + str);

				if (str.equals("CONSUME")) {
					//CONSUME表示要消费一条消息
					//从消息队列中消费一条消息
					String message = Broker.consume();
					out.println(message);
					out.flush();
				} else {
					//其他情况都表示生产消息到消息队列中
					Broker.produce(str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVICE_PORT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
			BrokerServer brokerServer = new BrokerServer(serverSocket.accept());
			new Thread(brokerServer).start();
		}
	}
}
