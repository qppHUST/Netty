package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

/**
 * ClassName: HelloClient
 * PackageName:netty
 * Description:
 * date: 2022/4/13 16:59
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
public class HelloClient {
    public static void main(String[] args) throws InterruptedException {
        //初始化器
        new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        //对信息进行编码
                        nioSocketChannel.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect("localhost",8080)
                .sync()
                .channel()
                //发送
                .writeAndFlush("hello,world");
    }
}
