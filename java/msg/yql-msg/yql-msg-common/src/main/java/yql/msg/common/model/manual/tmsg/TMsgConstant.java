package yql.msg.common.model.manual.tmsg;

/**
 * 消息常量
 * @author bm
 *
 */
public interface TMsgConstant {
	/**
	 * 默认发送的总次数
	 */
	Short SEND_NUM = 3;
	/**
	 * 默认重发次数
	 */
	Short RESET_NUM = 2;
	/**
	 * 消息类型-queue
	 */
	Short MSG_TYPE_QUEUE = 1;
	/**
	 * 消息类型-topic
	 */
	Short MSG_TYPE_TOPIC = 2;
	/**
	 * 生产者预发送消息类别
	 */
	Integer WAIT_SEND_TYPE = 1;
	/**
	 * 生产者业务操作失败
	 */
	Integer OPERATE_FAIL_TYPE = 2;
	/**
	 * 生产者业务操作成功
	 */
	Integer OPERATE_SUCCESS_TYPE = 3;
	/**
	 * 待确认
	 */
	Short WAIT_CONFIRM = 1;
	/**
	 * 待发送
	 */
	Short WAIT_SEND = 2;
	/**
	 * 已发送或发送成功
	 */
	Short SEND_SUCCESS = 3;
	/**
	 * 发送失败
	 */
	Short SEND_FAIL = 4;
	/**
	 * 消费端处理消息成功
	 */
	Short DEAL_SUCCESS = 5;
	/**
	 * 消费端处理消息失败
	 */
	Short DEAL_FAIL = 6;
}
