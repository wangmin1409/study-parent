package org.study.mq.mymq;

/**
 * @author wangmin
 * @description �����߿ͻ���
 * created at 2019/12/12 4:41 ����
 */
public class ConsumeClient {
	public static void main(String[] args) throws Exception {
		String message = MqClient.consume();
		System.out.println("��ȡ����ϢΪ��" + message);
	}
}
