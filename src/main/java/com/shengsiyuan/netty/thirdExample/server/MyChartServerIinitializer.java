package com.shengsiyuan.netty.thirdExample.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class MyChartServerIinitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast("lengthFiled",new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
//        pipeline.addLast("lengthFieldPrepender", new LengthFieldPrepender(4));
        pipeline.addLast("delimiterBasedFrameDecoder", new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
        pipeline.addLast("decoder", new StringDecoder(CharsetUtil.ISO_8859_1));
        pipeline.addLast("encoder",new StringEncoder(CharsetUtil.ISO_8859_1));
        pipeline.addLast("MyChartServer",new MyChartServerDecode());
    }
}
