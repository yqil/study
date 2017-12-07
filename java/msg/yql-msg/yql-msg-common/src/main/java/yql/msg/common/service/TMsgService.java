package yql.msg.common.service;

import yql.msg.common.model.auto.tmsg.TMsg;
import yql.msg.common.model.manual.tmsg.TMsgChildrenVO;
import yql.msg.common.util.exception.BusinessException;
import yql.msg.common.util.result.OutputPageResult;

/**
 * t_msg表操作服务接口类
 * @author bm
 *
 */
public interface TMsgService {
	/**
	 * 查询t_msg表信息，并带有分页效果
	 * @param msg 条件参数，如果page字段不为空，则带有分页效果，否则不带有分页效果
	 * @return
	 * @throws BusinessException
	 */
	public OutputPageResult queryTMsgPage(TMsgChildrenVO msg) throws BusinessException;
	/**
	 * 处理消息
	 * 
	 * 业务逻辑：
	 * 1、生产者在处理业务操作之前，先发送消息给消息中间件，消息中间件将消息保存，并将状态设置为1（待确认）
	 * 2、消息中间件将保存消息操作的结果返回给生产者
	 * 3、生产者接收到消息中间件的返回结果后，如果是成功，则进行业务处理，并将业务处理结果告诉消息中间件，如果失败，则不进行业务处理，此步无需再调用消息中间件
	 * 4、消息中间件接收到生产者发送的业务处理结果信息后，如果业务处理结果失败，则删除消息表中的消息，如果处理成功，则将消息内容通过mq投递出去
	 * 5、消息中间件投递消息成功后，生产者提交事务，否则生产者回滚业务操作。
	 * @param msg 
	 * @return 返回表id
	 * @throws BusinessException
	 */
	public String dealMsg(TMsgChildrenVO msg) throws BusinessException;
	
	/**
	 * 确认消息
	 * 
	 * 业务描述：
	 * 1、消息中间件将消息成功发送后，消费端接收到消息，并进行业务处理；
	 * 3、消费者业务操作处理结束后，调用该接口进行消息确认。
	 * 4、如果消息一段时间内未确认，中间件将根据上次发送时间和重试次数来自动重发消息，所以消费者业务操作应该实现幂等性
	 * 5、处理失败的消息，消息中间件也会根据上次发送时间和重试次数来自动重发消息
	 * @param msgId 消息id
	 * @param isSuccess 是否处理成功，成功为true，失败为false
	 * @return
	 * @throws BusinessException
	 */
	public String confirmMsg(String msgId, boolean isSuccess)throws BusinessException;
	/**
	 * 重新发送消息
	 * @param msg
	 * @return
	 * @throws BusinessException
	 */
	public void resetSendMsg(TMsg msg)throws BusinessException;
}
