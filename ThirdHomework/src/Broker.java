import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


public class Broker {

    private final static int  MAX_SIZE = 5;
    private static final BlockingDeque<String> messageQueue = new LinkedBlockingDeque<>(MAX_SIZE);

    public static void produce(String message){
        if(messageQueue.offer(message)){
            System.out.println("成功投递消息："+message+",当前暂存消息数量："+messageQueue.size());
        }else{
            System.out.println("Broker已经存不下了");
        }
    }
    public static String consume(){
        String message = messageQueue.poll();
        if(message != null){
            System.out.println("已消费消息：" + message + ",当前暂存消息数量："+messageQueue.size());
        }else {
            System.out.println("Broker内没有信息可以消费");
        }
        return message;
    }
}
