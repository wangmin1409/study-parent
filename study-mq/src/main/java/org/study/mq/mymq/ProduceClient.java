package org.study.mq.mymq;

/**
 * @author wangmin
 * @description �����߿ͻ���
 * created at 2019/12/12 4:42 ����
 */
public class ProduceClient {
	public static void main(String[] args) throws Exception {
		MqClient.produce("Hello World");
	}
}
